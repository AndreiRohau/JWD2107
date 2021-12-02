package com.jwd.functionalInterface;

import java.util.function.UnaryOperator;

public class MainCustom {
    private static String locale = "fr";

    public static void main(String[] args) {
        CustomFuncInterface<String> func = s -> "Hello " + s;
        UnaryOperator<String> unaryOperator = null;
        UnaryOperator<String> unaryOperator1 = s -> "Добро пожаловать товарисчи " + s;
        UnaryOperator<String> unaryOperator2 = s -> "Viva la France garson " + s;
        if (locale.equals("ru")) {
            unaryOperator = s -> "Добро пожаловать товарисчи " + s;
        } else {
            unaryOperator = s -> "Viva la France garson " + s;
        }

        System.out.println(func.sayHi("Jack"));
        System.out.println(func.sayHi("Bill"));
        System.out.println(unaryOperator.apply("Jack"));
        System.out.println(unaryOperator.apply("Bill"));

        System.out.println(runWelcomeProcess(unaryOperator1, "Jack"));
        System.out.println(runWelcomeProcess(unaryOperator2, "Jack"));
    }

    public static String runWelcomeProcess(UnaryOperator<String> unaryOperator, String s) {
        return unaryOperator.apply(s);
    }
}
