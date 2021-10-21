package com.jwd.generics.methodgen;

public class MethodGenMain {
    public static void main(String[] args) {
        MethodGen mg = new <String>MethodGen();
        Object o = mg.returnT("");
        Object o1 = mg.returnT("");
        String s = mg.<String>returnT("");

        Number n = 1;
        Integer i = 2;

        Number number = MethodGen.<Number>returnTExtends(n);
        Integer integer = MethodGen.<Integer>returnTExtends(i);
    }
}
