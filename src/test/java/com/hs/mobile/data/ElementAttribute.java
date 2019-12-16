package com.hs.mobile.data;

public enum ElementAttribute {
    ENABLED("enabled"),
    TEXT("text"),
    CLICKABLE("clickable"),
    FOCUSABLE("focusable");

    private String value;

    ElementAttribute(String value) {
        this.value = value;
    }

    public String getName() {
        return value;
    }
}
