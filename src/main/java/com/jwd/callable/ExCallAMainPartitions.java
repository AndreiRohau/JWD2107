package com.jwd.callable;

import com.jwd.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ExCallAMainPartitions {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        // data
        final List<Long> longs = LongStream.range(0, Range.TOTAL)
                .boxed()
                .collect(Collectors.toList());
//        System.out.println(longs);

        final int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors=" + availableProcessors);
        // prepare pieces of data in amount of availableProcessors (other words split data into almost equal parts)
        // 8 lists with 10 items each
        final List<List<Long>> parts = splitListIntoParts(longs, availableProcessors);

        // prepare thread pool in amount of availableProcessors
        final ExecutorService executor = Executors.newFixedThreadPool(availableProcessors);
        // prepare futures storage
        final List<Future<Long>> futures = new ArrayList<>();
        // run threads
        for (List<Long> partition : parts) {
            Future<Long> singleFuture = executor.submit(new ExCallA(partition));
            futures.add(singleFuture);
        }
        executor.shutdown();

        System.out.println("=======================WE ARE HERE!!!");
        // process futures
        long result = 0;
        System.out.println("=======================futures.size()=" + futures.size());
        for (Future<Long> future : futures) {
            long futureResult = future.get();
            System.out.println("future result=" + futureResult);
            result = result + future.get();
        }

        System.out.println("FINAL RESULT=" + result);
        System.out.println("END TIME !async! :" + (System.currentTimeMillis() - startTime));
        countSumOfAndTest(Range.TOTAL, result);
    }

    private static List<List<Long>> splitListIntoParts(List<Long> list, int amountOfParts) {
        List<List<Long>> partitions = new ArrayList<>(amountOfParts);
        int partitionMaxSize = (int) Math.ceil((double) list.size() / amountOfParts);
        for (int i = 0; i < amountOfParts; i++) {
            int startIndex = i * partitionMaxSize;
            int endIndex = Math.min((startIndex + partitionMaxSize), list.size());
            List<Long> partition = list.subList(startIndex, endIndex);
            partitions.add(partition);
        }
        return partitions;
    }

    private static void countSumOfAndTest(long rangeLastIndex, long result) {
        long sum = 0;
        for (long l = 0; l < rangeLastIndex; l++) {
            sum = sum + l;
        }
        System.out.println("TEST=" + sum);
        System.out.println("CORRECT=" + ((sum - result) == 0));
    }
}
