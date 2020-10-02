package lines.sample.code;

public enum HelloType {
    KOREA("Hello Korea!"),
    JAPAN("Hello Japan!");

    HelloType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private final String value;
}
