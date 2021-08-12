package com.jwd.methodCoupling;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MainTest {
    public static void main(String[] args) {
        String s;
        Collection c = new HashSet();
        prints(c);

        MainTest main = new MainTest();
        main.print(c);

        Test test = new Test();

        Test child = new TestChild();
        child.print(c);

        main.print(child);
    }

    private void print(Test t) {
        System.out.println("print(Test t)");
        t.print();
    }

    private void print(TestChild ts) {
        System.out.println("print(TestChild ts)");
        ts.print();
    }

    private static void prints(Collection c) {
        System.out.println("c");
    }

    private static void prints(Set s) {
        System.out.println("s");
    }

    private static void prints(HashSet hs) {
        System.out.println("hs");
    }

    private void print(Collection c) {
        System.out.println("c");
    }

    private void print(Set s) {
        System.out.println("s");
    }

    private void print(HashSet hs) {
        System.out.println("hs");
    }
}
