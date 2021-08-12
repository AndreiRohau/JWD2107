package com.jwd.constant;

public class MainEnum {
    public static void main(String[] args) {
        System.out.println(Country.REPUBLIC_OF_BELARUS);

        System.out.println("-----");
        // toString
        System.out.println(CountryEnum.REPUBLIC_OF_BELARUS);

        System.out.println("-----");
        // valueOf
        System.out.println(
                CountryEnum.valueOf("REPUBLIC_OF_BELARUS") // CountryEnum.REPUBLIC_OF_BELARUS
                        .getTitle()
        );

        System.out.println("-----");
        // values
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum value : values) {
            System.out.println(value);
        }

        System.out.println("-----");
        // name()
        System.out.println(CountryEnum.REPUBLIC_OF_BELARUS.name());
        System.out.println(CountryEnum.REPUBLIC_OF_BELARUS.toString());

        System.out.println("-----");
        // ordinal()
        System.out.println(CountryEnum.REPUBLIC_OF_BELARUS.ordinal());

    }
}
