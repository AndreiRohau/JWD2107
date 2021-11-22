package com.jwd.forkJoinTask;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static com.jwd.Range.TOTAL;

public class ForkJoinMainTest {
    public static void main(String[] args) {
        System.out.println("Straight - test");
        final List<Long> list = LongStream.range(0, TOTAL).boxed().collect(Collectors.toList());
        long startTime = System.currentTimeMillis();

        long result = SumRecursiveTask.getResult(list, 0, list.size());
        System.out.println("result=" + result);

        System.out.println("end in: " + (System.currentTimeMillis() - startTime));

    }
}
