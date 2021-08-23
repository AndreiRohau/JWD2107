package com.jwd.collection;

import java.util.HashSet;
import java.util.Set;

public class SetMain {
    private static Set<Integer> integerSet = new HashSet<>();

    public static void main(String[] args) {
        integerSet.add(1);
        integerSet.add(3);
        integerSet.add(5);
        integerSet.add(5);
        integerSet.add(7);
        System.out.println(integerSet.size());
    }
}
