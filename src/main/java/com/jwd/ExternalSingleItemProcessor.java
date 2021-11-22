package com.jwd;

public class ExternalSingleItemProcessor {
    public static <T> void processSingleItem(T t) throws InterruptedException {
//        System.out.println("Item t=" + t);
        Thread.sleep(1000); // !!! lets determine, each item takes 1s to be processed
    }
}
