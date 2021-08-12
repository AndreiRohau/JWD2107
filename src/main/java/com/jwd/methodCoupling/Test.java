package com.jwd.methodCoupling;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Test {
    Collection c = new HashSet();

    public Test() {
//        print(c);
    }

    public void print() {
        System.out.println("print test");
    }

    public void print(Collection c) {
        System.out.println("Collection");
    }

    public void print(Set s) {
        System.out.println("Set");
    }

    public void print(HashSet hs) {
        System.out.println("HashSet");
    }
}
