package lines.customannotations.sample;

import lines.customannotations.custom.StringInjector;

public class LineObject {
    @StringInjector("Line Object")
    private String name;

    @StringInjector
    private String defaultValue;

    @StringInjector
    private String invalidType;

    public String getName(){
        return name;
    }

    public String getDefaultValue(){
        return defaultValue;
    }

    public String getInvalidType() {
        return invalidType;
    }
}
