package com.enums;

public enum SizeEnum {

    SMALL("S"),
    MEDIUM("M"),

    LARGE("L"),

    EXTRA_LARGE("XL");

    private String abbreviation;

    SizeEnum(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
