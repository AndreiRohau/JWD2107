package com.jwdl1.main;

public class UtilChild extends com.jwdl1.util.UtilParent {
    void childMethod() {
        super.publicMethod();
        super.protectedMethod();
        Main main = new Main();

        com.jwdl1.util.UtilParent utilParent = new com.jwdl1.util.UtilParent();
        utilParent.publicMethod();
    }
}
