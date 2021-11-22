package com.jwd.forkJoinTask;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static com.jwd.Range.TOTAL;

public class ForkJoinMain {
    public static void main(String[] args) {
        System.out.println("ForkJoinTask - way");
        List<Long> list = LongStream.range(0, TOTAL).boxed().collect(Collectors.toList());
        long startTime = System.currentTimeMillis();

        ForkJoinTask<Long> task = new SumRecursiveTask(list);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ForkJoinPool forkJoinPool = new ForkJoinPool(20, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);
//        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long result = forkJoinPool.invoke(task);

        System.out.println("result=" + result);

        System.out.println("end in: " + (System.currentTimeMillis() - startTime));
    }
}
