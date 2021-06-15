import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParameterFinetuner {

    public ParameterFinetuner() {
    }

    // rolling until dead

    public void randomChooseParameterUp(WebDriver driver, Actions builder, Hyperparameter param) throws InterruptedException {

        double foo = (double) (Math.random() * 100);
//        int foo = (int) (Math.random() * 100);
//
//        if (foo < 21)  { // 14.28571
////            clickRequestedButton(driver, builder, TVXPaths.FAST_ELMNT, TVXPaths.FAST_UP);
////            param.setFastLeng(param.getFastLeng() + 1);
//            clickRequestedButton(driver, builder, TVXPaths.TP_ELMNT, TVXPaths.TP_UP);
//            param.setTakeProfit(param.getTakeProfit() + 0.1);
////        } else if (foo < 28.5701) {
////            clickRequestedButton(driver, builder, TVXPaths.SLOW_ELMNT, TVXPaths.SLOW_UP);
////            param.setSlowLeng(param.getSlowLeng() + 1);
////        } else if (foo < 42.8551) {
////            clickRequestedButton(driver, builder, TVXPaths.TP_ELMNT, TVXPaths.TP_UP);
////            param.setTakeProfit(param.getTakeProfit() + 0.1);
//        } else if (foo < 41) { // 57.1401
//            clickRequestedButton(driver, builder, TVXPaths.SL_ELMNT, TVXPaths.SL_UP);
//            param.setStopLoss(param.getStopLoss() + 0.1);
//        } else if (foo < 61) { // 71.4251
//            clickRequestedButton(driver, builder, TVXPaths.DEV_LENG_ELMNT, TVXPaths.DEV_LENG_UP);
//            param.setDeviationLeng(param.getDeviationLeng() + 1);
//        } else if (foo < 81) { // 85.7101
//            clickRequestedButton(driver, builder, TVXPaths.DEV_SCAL_ELMNT, TVXPaths.DEV_SCAL_UP);
//            param.setDeviationScale(param.getDeviationScale() + 1);
//        } else {
//            clickRequestedButton(driver, builder, TVXPaths.EXP_SCAL_ELMNT, TVXPaths.EXP_SCAL_UP);
//            param.setExpScale(param.getExpScale() + 0.01);
//        }

        if (foo < 14.2858) {
            clickRequestedButton(driver, builder, TVXPaths.FAST_ELMNT, TVXPaths.FAST_UP);
            param.setFastLeng(param.getFastLeng() + 1);
        } else if (foo < 28.5701) {
            clickRequestedButton(driver, builder, TVXPaths.SLOW_ELMNT, TVXPaths.SLOW_UP);
            param.setSlowLeng(param.getSlowLeng() + 1);
        } else if (foo < 42.8551) {
            clickRequestedButton(driver, builder, TVXPaths.TP_ELMNT, TVXPaths.TP_UP);
            param.setTakeProfit(param.getTakeProfit() + 0.1);
        } else if (foo < 57.1401) {
            clickRequestedButton(driver, builder, TVXPaths.SL_ELMNT, TVXPaths.SL_UP);
            param.setStopLoss(param.getStopLoss() + 0.1);
        } else if (foo < 71.4251) {
            clickRequestedButton(driver, builder, TVXPaths.DEV_LENG_ELMNT, TVXPaths.DEV_LENG_UP);
            param.setDeviationLeng(param.getDeviationLeng() + 1);
        } else if (foo < 85.7101) {
            clickRequestedButton(driver, builder, TVXPaths.DEV_SCAL_ELMNT, TVXPaths.DEV_SCAL_UP);
            param.setDeviationScale(param.getDeviationScale() + 1);
        } else {
            clickRequestedButton(driver, builder, TVXPaths.EXP_SCAL_ELMNT, TVXPaths.EXP_SCAL_UP);
            param.setExpScale(param.getExpScale() + 0.01);
        }
    }

    public void randomChooseParameterDown(WebDriver driver, Actions builder, Hyperparameter param)
            throws InterruptedException {

//        int foo = (int) (Math.random() * 100);

        double foo = (double) (Math.random() * 100);

//        if (foo < 21)  { // 14.28571
////            clickRequestedButton(driver, builder, TVXPaths.FAST_ELMNT, TVXPaths.FAST_UP);
////            param.setFastLeng(param.getFastLeng() + 1);
//            clickRequestedButton(driver, builder, TVXPaths.TP_ELMNT, TVXPaths.TP_DOWN);
//            param.setTakeProfit(param.getTakeProfit() - 0.1);
////        } else if (foo < 28.5701) {
////            clickRequestedButton(driver, builder, TVXPaths.SLOW_ELMNT, TVXPaths.SLOW_UP);
////            param.setSlowLeng(param.getSlowLeng() + 1);
////        } else if (foo < 42.8551) {
////            clickRequestedButton(driver, builder, TVXPaths.TP_ELMNT, TVXPaths.TP_UP);
////            param.setTakeProfit(param.getTakeProfit() + 0.1);
//        } else if (foo < 41) { // 57.1401
//            clickRequestedButton(driver, builder, TVXPaths.SL_ELMNT, TVXPaths.SL_DOWN);
//            param.setStopLoss(param.getStopLoss() - 0.1);
//        } else if (foo < 61) { // 71.4251
//            clickRequestedButton(driver, builder, TVXPaths.DEV_LENG_ELMNT, TVXPaths.DEV_LENG_DOWN);
//            param.setDeviationLeng(param.getDeviationLeng() - 1);
//        } else if (foo < 81) { // 85.7101
//            clickRequestedButton(driver, builder, TVXPaths.DEV_SCAL_ELMNT, TVXPaths.DEV_SCAL_DOWN);
//            param.setDeviationScale(param.getDeviationScale() - 1);
//        } else {
//            clickRequestedButton(driver, builder, TVXPaths.EXP_SCAL_ELMNT, TVXPaths.EXP_SCAL_DOWN);
//            param.setExpScale(param.getExpScale() - 0.01);
//        }
//
        if (foo < 14.2858) {
            clickRequestedButton(driver, builder, TVXPaths.FAST_ELMNT, TVXPaths.FAST_DOWN);
            param.setFastLeng(param.getFastLeng() - 1);
        } else if (foo < 28.5701) {
            clickRequestedButton(driver, builder, TVXPaths.SLOW_ELMNT, TVXPaths.SLOW_DOWN);
            param.setSlowLeng(param.getSlowLeng() - 1);
        } else if (foo < 42.8551) {
            clickRequestedButton(driver, builder, TVXPaths.TP_ELMNT, TVXPaths.TP_DOWN);
            param.setTakeProfit(param.getTakeProfit() - 0.1);
        } else if (foo < 57.1401) {
            clickRequestedButton(driver, builder, TVXPaths.SL_ELMNT, TVXPaths.SL_DOWN);
            param.setStopLoss(param.getStopLoss() - 0.1);
        } else if (foo < 71.4251) {
            clickRequestedButton(driver, builder, TVXPaths.DEV_LENG_ELMNT, TVXPaths.DEV_LENG_DOWN);
            param.setDeviationLeng(param.getDeviationLeng() - 1);
        } else if (foo < 85.7101) {
            clickRequestedButton(driver, builder, TVXPaths.DEV_SCAL_ELMNT, TVXPaths.DEV_SCAL_DOWN);
            param.setDeviationScale(param.getDeviationScale() - 1);
        } else {
            clickRequestedButton(driver, builder, TVXPaths.EXP_SCAL_ELMNT, TVXPaths.EXP_SCAL_DOWN);
            param.setExpScale(param.getExpScale() - 0.01);
        }
    }

    public void clickRequestedButton(WebDriver driver, Actions builder, TVXPaths xPathMove, TVXPaths xPathLocator)
            throws InterruptedException {

        int count = 0;
        int maxTries = 3;

        Thread.sleep(100);
        builder.moveToElement(driver.findElement(By.xpath(xPathMove.getxPath()))).perform();
        System.out.println("Moved to the element " + xPathMove.name());
        Thread.sleep(900);

        //org.openqa.selenium.NoSuchElementException
        while (true) {
            try {
                driver.findElement(By.xpath(xPathLocator.getxPath())).click();
                break;
            } catch (org.openqa.selenium.NoSuchElementException exception) {

                if (++count == maxTries) {
                    System.out.println("TRI POPITKI VSYO, YA LOMAUS NO SUCH ELEMENT");
                    throw exception;
                }

            }

        }


    }
}
