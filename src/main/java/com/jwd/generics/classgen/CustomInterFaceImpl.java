package com.jwd.generics.classgen;

public class CustomInterFaceImpl extends InterFaceImpl<String> {
    @Override
    public void m(String s) {
        System.out.println("hello string ");
    }
}
