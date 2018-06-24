package com.enums;

public enum Size {

    SMALL("S"),
    MEDIUM("M"),

    LARGE("L"),

    EXTRA_LARGE("XL");

    private String abbreviation;

    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
