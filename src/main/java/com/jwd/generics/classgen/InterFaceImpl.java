package com.jwd.generics.classgen;

public class InterFaceImpl<T> extends AbstractInterFace<Integer> {

    public void m(T t) {
        System.out.println(t);
    }

//    public void m(String s) {
//        System.out.println(s);
//    }

    @Override
    public String getT() {
        return null;
    }

    @Override
    public void setT(String s) {

    }
}
