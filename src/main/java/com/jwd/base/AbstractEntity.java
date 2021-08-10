package com.jwd.base;

public abstract class AbstractEntity {

    public static void staticAbstractClassM() {
        System.out.println("static AbstractProcessor method");
    }

    private String abstractsString;

    public AbstractEntity(String abstractsString) {
        this.abstractsString = abstractsString;
    }

    public void m1() {
        System.out.println("abstract m1");
    }

    public abstract void absM2();

}
