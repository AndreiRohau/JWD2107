package com.jwd.simple;

import java.util.concurrent.Callable;

public class ExCallable implements Callable<String> {

    public ExCallable() {
        System.out.println("THREAD inits : " + Thread.currentThread().getName());
    }

    @Override
    public String call() throws Exception {
        System.out.println("THREAD works : " + Thread.currentThread().getName());
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("ExCallable --->" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            System.out.println("DONE.ExCallable. name: " + Thread.currentThread().getName());
        }
        return "CALLABLE RESULT STRING";
    }
}
