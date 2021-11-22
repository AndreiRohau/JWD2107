package com.jwd.simple;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExCallableMain {

    public static void main(String[] args) throws Exception {
        Callable<String> callable = new ExCallable();

//        ExecutorService executor = Executors.newSingleThreadExecutor();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors=" + availableProcessors);
        ExecutorService executor = Executors.newFixedThreadPool(20);

        Future<String> future1 = executor.submit(callable);
        Future<String> future2 = executor.submit(callable);
        Future<String> future3 = executor.submit(callable);
        Future<String> future4 = executor.submit(callable);
        Future<String> future5 = executor.submit(callable);
        Future<String> future6 = executor.submit(callable);
        Future<String> future7 = executor.submit(callable);
        Future<String> future8 = executor.submit(callable);
        Future<String> future9 = executor.submit(callable);
        Future<String> future10 = executor.submit(callable);

        List<Future<String>> futures = Arrays.asList(
                future1,
                future2,
                future3,
                future4,
                future5,
                future6,
                future7,
                future8,
                future9,
                future10
                );

        // another way to run several processes
//        List<Future<String>> futures = executor.invokeAll(
//                Arrays.asList(
//                        callable, callable, callable,
//                        callable, callable, callable,
//                        callable, callable, callable,
//                        callable, callable, callable,
//                        callable, callable, callable
//                ));

        executor.shutdown();

        System.out.println("here");
        for (Future<String> future : futures) {
            System.out.println("result=" + future.get());
        }
        System.out.println("here");
    }
}
