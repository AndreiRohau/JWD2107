package com.jwd;

public abstract class AbstractTmpClass {
    String k;

    abstract void abstractMethod();

    public void method() {
        System.out.println("start");
        abstractMethod();
        System.out.println("end");
    }
}
