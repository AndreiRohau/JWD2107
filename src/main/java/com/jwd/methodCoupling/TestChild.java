package com.jwd.methodCoupling;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TestChild extends Test {
    @Override
    public void print() {
        System.out.println("print testChild");
    }

    @Override
    public void print(Collection c) {
        System.out.println("child c");
    }

    @Override
    public void print(Set s) {
        System.out.println("child s");
    }

    @Override
    public void print(HashSet hs) {
        super.print(hs);
    }
}
