package com.jwd;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.length() < 99;

        CustomFuncInterfaceAnother<Integer, String> ci = (i, s) -> System.out.println(i + " " + s);

        ci.run(5, "dollars");
    }

    public boolean test(String s) {
        return s.length() < 99;
    }
}
