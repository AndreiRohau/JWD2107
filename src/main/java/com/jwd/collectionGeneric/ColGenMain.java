package com.jwd.collectionGeneric;

import java.util.List;

public class ColGenMain {
    public static void main(String[] args) {

        // 1. List is not modifiable except NULL
        // 2. Object still modifiable

        List<Object> obj = null;
        List<Number> nums = null;
        List<Integer> ints = null;
        List<Long> longs = null;

        m1_wildcard(obj);
        m1_wildcard(nums);
        m1_wildcard(ints);
        m1_wildcard(longs);

        m1_super(obj);
        m1_super(nums);
//        m1_super(ints);
//        m1_super(longs);

//        m1_extends(obj);
        m1_extends(nums);
        m1_extends(ints);
        m1_extends(longs);
    }

    public static void m1_wildcard(List<?> list) {
        if (list == null) {
            return;
        }
        list.forEach(System.out::println);
//        list.add("a string");
    }

    public static void m1_super(List<? super Number> list) {
        if (list == null) {
            return;
        }
        list.forEach(System.out::println);
    }

    public static void m1_extends(List<? extends Number> list) {
        if (list == null) {
            return;
        }
        list.forEach(System.out::println);
        list.add(null);
    }

}
