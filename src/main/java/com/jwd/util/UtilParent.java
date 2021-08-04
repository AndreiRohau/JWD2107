package com.jwd.util;

public class UtilParent {
    public int ipub = 1;
    protected int iprot = 1;
    int idef = 1;
    private int ipriv = 1;

    public void publicMethod() {
        System.out.println("publicMethod");
    }
    protected void protectedMethod() {
        System.out.println("protectedMethod");
    }
    void defaultMethod() {
        System.out.println("defaultMethod");
    }
    private void privateMethod() {
        System.out.println("privateMethod");
    }
}
