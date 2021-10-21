package com.jwd.generics.methodgen;

public class MethodGen {

    public <T extends String> MethodGen() {

    }

    public <T> T returnT(String s) {
        return (T) s;
    }

//    public <T extends Integer> T returnTExtends(T t) {
//        return t;
//    }

    public static <T extends Number> T returnTExtends(T t) {
        System.out.println(t);
        return t;
    }
}
