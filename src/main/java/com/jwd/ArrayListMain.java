package com.jwd;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        integerList.add(6);
        integerList.add(7);
        integerList.add(12);
        integerList.add(null);
        integerList.add(13);
        integerList.add(13);
        integerList.add(13);
        integerList.add(6);

        System.out.println(integerList);

        integerList.add(5, null);
        integerList.add(6, 6);

        System.out.println(integerList);
        integerList.remove(4);
        System.out.println(integerList);
        integerList.remove(new Integer(6));
        System.out.println(integerList);

    }
}
