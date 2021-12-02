package com.jwd.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainA {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "aaa", "bbb", "cc", "da", "eee", "aaa"
        );

        List<String> results = strings
                .stream()
                .peek(s -> {
                    System.out.print(s);
                    System.out.println(" hellow");
                })
                .distinct()
                .peek(s -> {
                    System.out.print(s);
                    System.out.println(" nodup");
                })
                .filter(e -> {
                    if (e.contains("a")) {
                        return false;
                    } else {
                        return true;
                    }
                })
                .peek(e -> System.out.println("filtered " + e))
                .collect(Collectors.toList());


    }
}
