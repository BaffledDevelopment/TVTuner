public enum TVXPaths {

    PROFITABILITY ("//*[@id=\"bottom-area\"]/div[4]/div[2]/div/div[2]/div[1]/div[4]/strong"),
    NUMBER_OF_TRADES ("//*[@id=\"bottom-area\"]/div[4]/div[2]/div/div[2]/div[1]/div[2]/strong"),
    CLOSE_PARAM_TAB ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[1]/span"),
    DRAWDOWN_USD ("//*[@id=\"bottom-area\"]/div[4]/div[2]/div/div[2]/div[1]/div[5]/strong/span"),
    DRAWDOWN_PERCENTAGE ("//*[@id=\"bottom-area\"]/div[4]/div[2]/div/div[2]/div[1]/div[5]/p/span/span"),

    SLOW_INPUT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[6]/div/span/span[1]/input"),
    SLOW_ELMNT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[6]/div/span/span[2]/div"),
    SLOW_UP ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[6]/div/span/span[2]/div/button[1]"),
    SLOW_DOWN ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[6]/div/span/span[2]/div/button[2]"),

    FAST_INPUT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[4]/div/span/span[1]/input"),
    FAST_ELMNT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[4]/div/span/span[2]/div"),
    FAST_UP ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[4]/div/span/span[2]/div/button[1]"),
    FAST_DOWN ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[4]/div/span/span[2]/div/button[2]"),

    TP_INPUT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[8]/div/span/span[1]/input"),
    TP_ELMNT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[8]/div/span/span[2]/div"),
    TP_UP ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[8]/div/span/span[2]/div/button[1]"),
    TP_DOWN ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[8]/div/span/span[2]/div/button[2]"),

    SL_INPUT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[10]/div/span/span[1]/input"),
    SL_ELMNT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[10]/div/span/span[2]/div"),
    SL_UP ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[10]/div/span/span[2]/div/button[1]"),
    SL_DOWN ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[10]/div/span/span[2]/div/button[2]"),

    TRAIL_INPUT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[13]/div/span/span[1]/input"),
    TRAIL_ELMNT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[13]/div/span/span[2]/div"),
    TRAIL_UP ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[13]/div/span/span[2]/div/button[1]"),
    TRAIL_DOWN ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[13]/div/span/span[2]/div/button[2]"),

    DEV_LENG_INPUT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[16]/div/span/span[1]/input"),
    DEV_LENG_ELMNT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[16]/div/span/span[2]/div"),
    DEV_LENG_UP ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[16]/div/span/span[2]/div/button[1]"),
    DEV_LENG_DOWN ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[16]/div/span/span[2]/div/button[2]"),

    DEV_SCAL_INPUT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[18]/div/span/span[1]/input"),
    DEV_SCAL_ELMNT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[18]/div/span/span[2]/div"),
    DEV_SCAL_UP ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[18]/div/span/span[2]/div/button[1]"),
    DEV_SCAL_DOWN ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[18]/div/span/span[2]/div/button[2]"),

    EXP_SCAL_INPUT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[20]/div/span/span[1]/input"),
    EXP_SCAL_ELMNT ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[20]/div/span/span[2]/div"),
    EXP_SCAL_UP ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[20]/div/span/span[2]/div/button[1]"),
    EXP_SCAL_DOWN ("//*[@id=\"overlap-manager-root\"]/div/div/div[1]/div/div[3]/div/div[20]/div/span/span[2]/div/button[1]");

    private  String xPath;

    TVXPaths(String xPath) {
        this.xPath = xPath;
    }

    public String getxPath() {
        return xPath;
    }
}
