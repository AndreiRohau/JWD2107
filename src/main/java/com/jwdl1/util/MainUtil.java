package com.jwdl1.util;

public class MainUtil {
    public static void main(String[] args) {
        UtilParent utilParent = new UtilParent();
        utilParent.publicMethod(); // everywhere
        utilParent.protectedMethod(); // package + ancestors
        utilParent.defaultMethod(); // package private
    }
}
