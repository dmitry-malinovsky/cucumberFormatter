package cucumberFormatter.adapters;

public enum Status {
    PASSED("passed"),
    FAILED("failed"),
    SKIPPED("skipped"),
    UNDEFINED("undefined");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
