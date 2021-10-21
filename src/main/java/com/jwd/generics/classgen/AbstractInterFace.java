package com.jwd.generics.classgen;

public class AbstractInterFace<K> implements InterFace<String> {

    void printK(K k) {
        System.out.println(k);
    }

    @Override
    public String getT() {
        return null;
    }

    @Override
    public void setT(String s) {

    }
}
