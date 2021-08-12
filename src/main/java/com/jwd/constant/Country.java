package com.jwd.constant;

public class Country {
    public static final Country REPUBLIC_OF_BELARUS = new Country("Беларусь");
    public static final Country UKRAINE = new Country("Украина");
    public static final Country ITALY = new Country("Италия");

    private final Country[] values = { REPUBLIC_OF_BELARUS, UKRAINE, ITALY };

    private final String title;

    private Country(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Country[] values() {
        return values.clone();
    }
}
