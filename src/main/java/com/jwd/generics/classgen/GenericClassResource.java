package com.jwd.generics.classgen;

import java.io.Serializable;

public class GenericClassResource<T, K extends Number, V extends K, N extends Serializable> {
    private String id;
    private T resource;
    private K key;
    private V value;
    private N[] array;
//    private static V value__; // error

    // error
//    public static void m(K k) {
//        // code...
//    }

    public GenericClassResource() {
//        K k = new K(); // error
    }

    public void m1(T t) {
        System.out.println("T");
    }

    public void m1(String s) {
        System.out.println("String");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getResource() {
        return resource;
    }

    public void setResource(T resource) {
        this.resource = resource;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}
