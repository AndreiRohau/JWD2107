package com.jwd;

import java.util.HashMap;
import java.util.Map;

public class MainMapUser {
    public static void main(String[] args) {
        User john = new User("john", 15);
        System.out.println(john.hashCode());
        User john1 = new User("john", 1);
        User john2 = new User("john", 2);
        User john3 = new User("john", 3);
        User john4 = new User("john", 4);
        User merry = new User("merry", 16);
        System.out.println(merry.hashCode());
        HashMap<User, String> hashMap = new HashMap<>();
        hashMap.put(john, "JOHN");
        hashMap.put(merry, "MERRY");
        System.out.println(hashMap.size());
//        printMap(users);

        // entryset
        System.out.println("_____entry_SET_____");
        for (Map.Entry<User, String> stringIntegerEntry : hashMap.entrySet()) {
            System.out.print(stringIntegerEntry.getKey());
            System.out.print(" ");
            System.out.print(stringIntegerEntry.getValue());
            System.out.print(" ");
            System.out.print(stringIntegerEntry.hashCode());
            System.out.print(" ");
            System.out.print(stringIntegerEntry.setValue(stringIntegerEntry.getValue().toUpperCase() + "Christmas"));
            System.out.println();
        }
        printMap(hashMap);
    }

    private static void printMap(HashMap<User, String> hashMap) {
        System.out.println("PRINT_MAP__________________________");
        for (User key : hashMap.keySet()) {
            String kvpair = key + " " + hashMap.get(key);
            System.out.println(kvpair);
        }
    }
}
