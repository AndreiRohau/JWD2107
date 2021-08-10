package com.jwd.base;

public interface Int2 {

    static void staticM() {
        System.out.println("static Int method");
    }

    void interfaceM();

    default void interfaceM2() {
        System.out.println("Int2");
    };
}
