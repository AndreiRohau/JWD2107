package com.jwd.generics.classgen;

public class GenericClassMain {
    public static void main(String[] args) {
        GenericClassResource objectKeeper = new GenericClassResource();
        GenericClassResource<String, Number, Integer, Integer> objectKeeper_ = new GenericClassResource<>();
        GenericClassResource<String, Integer, Integer, Integer> integerKeep = new GenericClassResource<>();
        GenericClassResource<String, Double, Double, Integer> doubleKeep = new GenericClassResource<>();
        GenericClassResource<String, Double, Double, Integer> stringKeeper = new GenericClassResource<>();

        InterFaceImpl<String> commonS = new InterFaceImpl<>();
        commonS.m("asdasdasd");
        InterFaceImpl<Integer> commonI = new InterFaceImpl<>();
        commonI.m(1123);

        InterFaceImpl<String> commonCs = new CustomInterFaceImpl();
        commonCs.m("asdasdasdasdasd");
    }
}
