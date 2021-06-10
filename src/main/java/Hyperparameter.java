public class Hyperparameter implements Cloneable {

    String exampleName;

    int fastLeng;
    int slowLeng;
    int timeFrame;
    int closedTrades;
    int deviationLeng;
    int deviationScale;


    double stopLoss;
    double takeProfit;
    double trail;
    double profitability;
    double expScale;
    double errorFunc;
    String drawdown_usd;
    String drawdown_percentage;

    int source;

    public Hyperparameter() {

    }

    public String getDrawdown_percentage() {
        return drawdown_percentage;
    }

    public String getDrawdown_usd() {
        return drawdown_usd;
    }

    public void setDrawdown_percentage(String drawdown_percentage) {
        this.drawdown_percentage = drawdown_percentage;
    }

    public void setDrawdown_usd(String drawdown_usd) {
        this.drawdown_usd = drawdown_usd;
    }

    public Hyperparameter clone() throws CloneNotSupportedException {
        return (Hyperparameter) super.clone();
    }

    public double getErrorFunc() {
        return errorFunc;
    }

    public void setErrorFunc(double errorFunc) {
        this.errorFunc = errorFunc;
    }

    public int getDeviationLeng() {
        return deviationLeng;
    }

    public void setDeviationLeng(int deviationLeng) {
        this.deviationLeng = deviationLeng;
    }

    public int getDeviationScale() {
        return deviationScale;
    }

    public void setDeviationScale(int deviationScale) {
        this.deviationScale = deviationScale;
    }

    public double getExpScale() {
        return expScale;
    }

    public void setExpScale(double expScale) {
        this.expScale = expScale;
    }

    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    public double getProfitability() {
        return profitability;
    }

    public String getExampleName() {
        return exampleName;
    }

    public void setExampleName(String exampleName) {
        this.exampleName = exampleName;
    }

    public int getFastLeng() {
        return fastLeng;
    }

    public int getClosedTrades() {
        return closedTrades;
    }

    public void setClosedTrades(int closedTrades) {
        this.closedTrades = closedTrades;
    }

    public int getSlowLeng() {
        return slowLeng;
    }

    public int gettimeFrame() {
        return timeFrame;
    }

    public double getStopLoss() {
        return stopLoss;
    }

    public double getTakeProfit() {
        return takeProfit;
    }

    public double getTrail() {
        return trail;
    }

    public int getSource() {
        return source;
    }

    public void setFastLeng(int fastLeng) {
        this.fastLeng = fastLeng;
    }

    public void setSlowLeng(int slowLeng) {
        this.slowLeng = slowLeng;
    }

    public void setTimeFrame(int timeFrame) {
        this.timeFrame = timeFrame;
    }

    public void setStopLoss(double stopLoss) {
        this.stopLoss = stopLoss;
    }

    public void setTakeProfit(double takeProfit) {
        this.takeProfit = takeProfit;
    }

    public void setTrail(double trail) {
        this.trail = trail;
    }

    public void setSource(int source) {
        this.source = source;
    }
}
