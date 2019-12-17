package com.hs.mobile.data;

public enum Language {
    ARABIC("ar"),
    ENGLISH("en");

    private String value;

    Language(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
