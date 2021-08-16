package com.jwd.stringIntern;

public class MainStringIntern {
    public static void main(String[] args) {
        String o1 = new String("hi");
        String o2 = new String("hi").intern();
        String s1 = "hi";
        String s2 = "hi";
        System.out.println(o1 == s1);
        System.out.println(s1 == s2);
        System.out.println(o2 == s2);

        s1 = "hi2";
    }
}
