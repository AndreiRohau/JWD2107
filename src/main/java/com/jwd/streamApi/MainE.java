package com.jwd.streamApi;

import java.util.stream.IntStream;

public class MainE {
    public static void main(String[] args) {
        IntStream range = IntStream.range(1, Integer.MAX_VALUE);

        int sum = range
                .peek(e -> System.out.println(e))
                .filter(e -> e % 2 == 0)
                .peek(e -> System.out.println(e))
                .limit(5)
                .sum();
        System.out.println(sum);

        getSumBetween(1, Integer.MAX_VALUE);
    }

    public static int getSumBetween(int startInclusive, int endExclusive) {
        return IntStream.range(startInclusive, endExclusive)
                .peek(e -> System.out.println(e))
                .filter(e -> e % 2 == 0)
                .peek(e -> System.out.println(e))
                .limit(5)
                .sum();
    }
}
