package com.lines.basic.webserver04.core.code;

public enum ResponseCode {
    HTTP_200("200"),
    HTTP_301("301"),
    HTTP_302("302"),
    HTTP_500("500");

    private final String value;

    ResponseCode(String value) {
        this.value = value;
    }
}
