package com.jwd.collection;

import com.jwd.error.User;

import java.awt.print.Pageable;
import java.util.*;

public class MainCollection {
    ArrayList<String> arrayList = new ArrayList<>();
    LinkedList<String> linkedList = new LinkedList<>();

    HashSet<String> hashSet = new HashSet<>();
    HashMap<String, String> hashMap = new HashMap<>();

    public static void main(String[] args) {
        String[] strings = new String[10];

        List<String> arrayList = new ArrayList<>();
        System.out.println(arrayList.add("asd"));
        System.out.println(arrayList.add("fgh")); // index 1
        System.out.println(arrayList.add("jkl"));
        System.out.println("size=" + arrayList.size());
        System.out.println("index 1=" + arrayList.get(1)); // fgh
        arrayList.add(1, "123");
        System.out.println("index 1=" + arrayList.get(1)); // 123
        System.out.println("size=" + arrayList.size());
        System.out.println("remove 1=" + arrayList.remove(1));
        System.out.println("index 1=" + arrayList.get(1)); // jkl
        System.out.println(arrayList.contains("asd"));
        System.out.println(arrayList.contains("qwe"));
        System.out.println(arrayList.indexOf("asd"));
        System.out.println(arrayList.indexOf("123"));

        System.out.println(arrayList.get(1000));

        LinkedList<String> linkedList = new LinkedList<>();
    }
}
