import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Driver;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

//@JsonSerialize(using = HyperSerializer.class)
public class HelloSelenium {

    public static Map<TVXPaths, String> defaultParams = Map.of(
            TVXPaths.TP_INPUT, "5",
            TVXPaths.SL_INPUT, "4",
            TVXPaths.TRAIL_INPUT, "1",
            TVXPaths.DEV_LENG_INPUT,"5",
            TVXPaths.DEV_SCAL_INPUT, "-50",
            TVXPaths.EXP_SCAL_INPUT, "0.01");


    public static void main(String[] args) throws InterruptedException, IOException, CloneNotSupportedException {

        double profit;
        double profit_tune;

//        Map<TVXPaths, String> defaultParams = Map.of(
//                TVXPaths.TP_INPUT, "5",
//                TVXPaths.SL_INPUT, "4",
//                TVXPaths.TRAIL_INPUT, "1",
//                TVXPaths.DEV_LENG_INPUT,"5",
//                TVXPaths.DEV_SCAL_INPUT, "-50",
//                TVXPaths.EXP_SCAL_INPUT, "0.01");


//        PrintWriter out = new PrintWriter("filename.txt");

        Hyperparameter theBestParams = new Hyperparameter();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("user-data-dir=C:\\Users\\RyzenPC\\ChromeProfiles\\User Data");

        // very weird bug using chrome profiles, refer to this link for more info
        // https://www.reddit.com/r/learnpython/comments/djisjv/how_to_use_a_chrome_profile_with_selenium/

        WebDriver driver = new ChromeDriver(options);
        Actions builder = new Actions(driver);

        GeneticAlgorithm freshGA = new GeneticAlgorithm();
        List<Hyperparameter> populatedList = freshGA.createPopulation();
//        TVXPaths tvxPaths = new TradingViewXPaths();
        openChrome(driver);
        fillFieldsWithDefault(driver);

        // ------------The fittest------------------ //

        double maxFit = Double.MIN_VALUE;

        int tradesNumberMin = 100;
        String maxFitName = "";

        for (Hyperparameter param : populatedList) {
            inputParametersChrome(driver, param); // parse everything for all objects
        }


        double a_coeff = 5.554630279541016;
        double b_coeff = 4.928399085998535;
        int totalTrades;
        int totalTrades_tune;
        double funcL;
        int w1 = 1;
        int w2 = 5;
        double funcP;
        double funcT;
        double minError = Double.MAX_VALUE;

        for (Hyperparameter child : populatedList) {
            profit = child.getProfitability();
            totalTrades = child.getClosedTrades();

            funcP = Math.exp(-profit + a_coeff) + b_coeff;
            funcT = Math.exp(-totalTrades*0.01 + a_coeff) + b_coeff;

            funcL = w1 * funcP + w2 * funcT;

            child.setErrorFunc(funcL);

            if (minError >= funcL) {
                minError = funcL;
                maxFitName = child.getExampleName();
                theBestParams = child.clone();
            }
        }

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = "";
        StringBuilder stringBuilder = new StringBuilder(jsonString);

        stringBuilder.append(mapper.writeValueAsString(theBestParams)).append("\n").append(maxFitName);

        File file = new File("filewithjson.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(stringBuilder.toString());
        }

        // -------------- Finetuning the fittest -----------//

        inputParametersChrome(driver, theBestParams);
        ParameterFinetuner tuner = new ParameterFinetuner();
        Hyperparameter fineTunedParams = theBestParams.clone();

        for (int i = 0; i < 1000; i++) {

            int foo = (int) (Math.random() * 100);
            if (foo < 71) {
                System.out.println("Do nothing yet again " + i);

            }                 // 70% chance do nothing
            else if (foo < 86) {
                tuner.randomChooseParameterUp(driver, builder, theBestParams);
                getProfitabilityNumberGetBack(driver, theBestParams);
                profit_tune = theBestParams.getProfitability();
                totalTrades_tune = theBestParams.getClosedTrades();

                funcP = Math.exp(-profit_tune + a_coeff) + b_coeff;
                funcT = Math.exp(-totalTrades_tune*0.01 + a_coeff) + b_coeff;

                funcL = w1 * funcP + w2 * funcT;

                theBestParams.setErrorFunc(funcL);

                if (minError >= funcL) {
                    minError = funcL;
                    maxFitName = theBestParams.getExampleName();
                    fineTunedParams = theBestParams.clone();
                    System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(fineTunedParams));
                }
//                if (maxFit <= profit) {
//                    maxFit = profit;
//                    fineTunedParams = theBestParams.clone();
//                    System.out.println(mapper.writeValueAsString(fineTunedParams));
//                }
            } // choose random param and move it once in chosen direction
            else {
                tuner.randomChooseParameterDown(driver, builder, theBestParams);// choose random param

                getProfitabilityNumberGetBack(driver, theBestParams);

                profit_tune = theBestParams.getProfitability();
                totalTrades_tune = theBestParams.getClosedTrades();

                funcP = Math.exp(-profit_tune + a_coeff) + b_coeff;
                funcT = Math.exp(-totalTrades_tune*0.01 + a_coeff) + b_coeff;

                funcL = w1 * funcP + w2 * funcT;

                theBestParams.setErrorFunc(funcL);

                if (minError >= funcL) {
                    minError = funcL;
                    maxFitName = theBestParams.getExampleName();
                    fineTunedParams = theBestParams.clone();
                    System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(fineTunedParams));
                }
//                if (maxFit <= profit) {
//                    maxFit = profit;
//                    fineTunedParams = theBestParams.clone();
//                    System.out.println(mapper.writeValueAsString(fineTunedParams));
//
//                 }
            }
        }

        StringBuilder stringBuilder1 = new StringBuilder(jsonString);
        stringBuilder1.append(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(fineTunedParams));
//                .append("\n").append(maxFitName);

        System.out.println(stringBuilder1);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("TunedJson.json", true))) {
            writer.write(stringBuilder1.toString());
        }
    }

    public static void openChrome(WebDriver driver) throws InterruptedException {
        driver.get("https://www.tradingview.com/chart/DCSi2WaY/");

        Thread.sleep(1000);
        WebElement strategySettingsButton = new WebDriverWait(driver, Duration.ofSeconds(1).toSeconds()).until
                (driver1 -> driver1.findElement(By.className("icon-button")));
        strategySettingsButton.click();

    }

    public static void getProfitabilityNumberGetBack(WebDriver driver, Hyperparameter hyperparameter) throws InterruptedException {

        Thread.sleep(100);

        driver.findElement(By.xpath(TVXPaths.CLOSE_PARAM_TAB.getxPath())).click();

        int count = 0;
        int maxTries = 3;

        while (true) {
            try {

                Thread.sleep(1000);

                WebElement getProfitFactor = driver.findElement(By.xpath(TVXPaths.PROFITABILITY.getxPath()));
                hyperparameter.setProfitability(Double.parseDouble(getProfitFactor.getText()));

                Thread.sleep(100);

                WebElement getNumberOfClosedTrades = driver.findElement(By.xpath(TVXPaths.NUMBER_OF_TRADES.getxPath()));
                hyperparameter.setClosedTrades(Integer.parseInt(getNumberOfClosedTrades.getText()));

                Thread.sleep(100);

                WebElement getDrawdownUSD = driver.findElement(By.xpath(TVXPaths.DRAWDOWN_USD.getxPath()));
                hyperparameter.setDrawdown_usd(getDrawdownUSD.getText());

                Thread.sleep(100);

                WebElement getDrawdownPercent = driver.findElement(By.xpath(TVXPaths.DRAWDOWN_PERCENTAGE.getxPath()));
                hyperparameter.setDrawdown_percentage(getDrawdownPercent.getText());

                break;

            } catch (org.openqa.selenium.StaleElementReferenceException e) {

                if (++count == maxTries) {
                    System.out.println("TRI POPITKI VSYO, YA LOMAUS STALE REFERENCE");
                    throw e;
                }
            }
        }

        WebElement strategySettingsButton = new WebDriverWait(driver, Duration.ofSeconds(1).toSeconds()).until
                (driver1 -> driver1.findElement(By.className("icon-button"))); // page takes a lot of time to load
        strategySettingsButton.click();
    }

    public static void inputParams(WebDriver driver, TVXPaths xPathElem, String inputString) {
        WebElement locateElement = new WebDriverWait(driver, Duration.ofSeconds(1).toSeconds()).until
                (driver1 -> driver1.findElement(By.xpath(xPathElem.getxPath())));

        for (int i = 0; i < 3; i++){
            locateElement.sendKeys(Keys.BACK_SPACE);
        }

        locateElement.sendKeys(inputString);
    }

    public static void inputParametersChrome(WebDriver driver, Hyperparameter hyperparameter) throws InterruptedException {

        inputParams(driver, TVXPaths.FAST_INPUT, "999");
        inputParams(driver, TVXPaths.SLOW_INPUT, Integer.toString(hyperparameter.getSlowLeng()));
        Thread.sleep(100);
        inputParams(driver, TVXPaths.FAST_INPUT, Integer.toString(hyperparameter.getFastLeng()));

        getProfitabilityNumberGetBack(driver, hyperparameter);

        System.out.println(hyperparameter.getExampleName() + "profitability is " + hyperparameter.getProfitability());
    }

    public static void fillFieldsWithDefault(WebDriver driver) throws InterruptedException {

        Thread.sleep(100);

        for (Map.Entry<TVXPaths, String> param : defaultParams.entrySet()) {
            Thread.sleep(100);
            inputParams(driver, param.getKey(), param.getValue());
        }
    }
}
