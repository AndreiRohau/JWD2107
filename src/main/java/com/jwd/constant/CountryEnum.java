package com.jwd.constant;

public enum CountryEnum {
    EMPTY_COUNTRY(0, "ТАКОЙ СТРАНЫ НЕТ"),
    REPUBLIC_OF_BELARUS(1, "Беларусь"),
    UKRAINE(2, "Украина"),
    ITALY(3, "Италия");

    private long id;
    private String title;

    CountryEnum(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public CountryEnum getEnumById(long id) {
        CountryEnum countryEnum = EMPTY_COUNTRY; // null returns when enum not found
        for (CountryEnum value : CountryEnum.values()) {
            if (value.id == id) {
                countryEnum = value;
            }
        }
        return countryEnum;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
