package com.jwd.main;

public class UtilChild extends com.jwd.util.UtilParent {
    void childMethod() {
        super.publicMethod();
        super.protectedMethod();
        Main main = new Main();

        com.jwd.util.UtilParent utilParent = new com.jwd.util.UtilParent();
        utilParent.publicMethod();
    }
}
