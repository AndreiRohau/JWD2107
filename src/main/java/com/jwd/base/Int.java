package com.jwd.base;

public interface Int {

    public static void staticM() {
        System.out.println("static Int method");
    }

    void interfaceM();
    String interfaceM(int i);

    default void interfaceM2() {
        System.out.println("Int");
    };
}
