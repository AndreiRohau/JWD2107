package com.jwd;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap();
        hashMap.put("Belarus", 220000);
        hashMap.put("Russia", 170000);
        hashMap.put("Ukraine", 165000);
        hashMap.put("Ukraine", 900000);
        hashMap.put("Ukraine", null);
        hashMap.put(null, 0);
        hashMap.put(null, 1);
        hashMap.put(null, 2);

        System.out.println("___________________");
        System.out.println(hashMap.get("Belarus"));
        System.out.println("___________NOT_deep_clone________");
        hashMap.clone();
        System.out.println("________Values___________");
        System.out.println(hashMap.values());
        System.out.println("________size___________");
        System.out.println(hashMap.size());
        System.out.println("___________________");
        hashMap.remove("Russia");
        System.out.println("___________________");
        hashMap.remove("Ukraine", 123);
        System.out.println("___________________");
        System.out.println("___________________");
//        hashMap.clear();

        printMap(hashMap);

    }

    private static void printMap(HashMap<String, Integer> hashMap) {

        System.out.println("__________MAP_________");
        for (String key : hashMap.keySet()) {
            String kvpair = key + " " + hashMap.get(key);
            System.out.println(kvpair);
        }
    }
}
