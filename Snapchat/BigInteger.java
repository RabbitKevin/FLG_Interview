class BigInteger {
    private String presentation;
    private boolean isPositive;
    public BigInteger(String str, boolean positive) {
        presentation = String.valueOf(str);
        isPositive = positive;
    }

    public String getValue() {
        if(isPositive) return presentation;
        return "-"+presentation;
    }

    public String getAbs() {
        return presentation;
    }

    public BigInteger add(BigInteger num) {

    }

    public BigInteger substract(BigInteger) {

    }

    public boolean isPositive() {
        return isPositive;
    }
    private String addHelp(String x, String y) {

    }
}
