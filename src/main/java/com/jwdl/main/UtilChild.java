package com.jwdl.main;

public class UtilChild extends com.jwdl.util.UtilParent {
    void childMethod() {
        super.publicMethod();
        super.protectedMethod();
        Main main = new Main();

        com.jwdl.util.UtilParent utilParent = new com.jwdl.util.UtilParent();
        utilParent.publicMethod();
    }
}
