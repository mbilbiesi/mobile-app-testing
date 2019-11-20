package com.hs.mobile.enumeration;

public enum ElementAttribute {
    ENABLED("enabled"),
    TEXT("text");

    private String value;

    ElementAttribute(String value) {
        this.value = value;
    }

    public String getName() {
        return value;
    }
}
