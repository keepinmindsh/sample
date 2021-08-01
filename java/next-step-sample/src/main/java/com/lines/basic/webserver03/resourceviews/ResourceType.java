package com.lines.basic.webserver03.resourceviews;

public enum ResourceType {
    VIEW_HTML(".html"),
    DATA("");

    private final String name;

    ResourceType(final String name) {
        this.name = name;
    }

    public static ResourceType of(String name){
        switch (name){
            case ".html" :
                return VIEW_HTML;
            case "" :
                return DATA;
            default:
                return null;
        }
    }
}
