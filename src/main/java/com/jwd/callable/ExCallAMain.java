package com.jwd.callable;

import com.jwd.Range;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ExCallAMain {
    private static final List<Long> longs = LongStream.range(0, Range.TOTAL)
            .boxed()
            .collect(Collectors.toList());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
//        System.out.println(longs);
        Callable<Long> callable = new ExCallA(longs);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Long> future = executor.submit(callable);
        executor.shutdown();

        System.out.println(future.get());

        System.out.println("END TIME !async! :" + (System.currentTimeMillis() - startTime));
    }
}
