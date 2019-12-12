package com.hs.mobile.data;

public enum ElementAttribute {
    ENABLED("enabled"),
    TEXT("text"),
    CHECKED("checked");

    private String value;

    ElementAttribute(String value) {
        this.value = value;
    }

    public String getName() {
        return value;
    }
}
