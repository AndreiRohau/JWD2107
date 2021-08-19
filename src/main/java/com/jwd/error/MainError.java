package com.jwd.error;

public class MainError {
    public static void main(String[] args) {
        try {
//            Error stackOverflowError = new StackOverflowError();
//            Error outOfMemoryError = new OutOfMemoryError();
//            throw outOfMemoryError;

//            producesStackOverflowError();

            producesOutOfMemoryError(Integer.MAX_VALUE);
        } catch (Error error) {
            System.out.println("hey look we have caught an error)))");
            if (error.getClass().getName().equals("java.lang.OutOfMemoryError")) {
                System.out.println("WOW!!! let's think how to release some memory to recover your App");
            }
            error.printStackTrace();
        }
    }

    private static void producesOutOfMemoryError(int size) {
        long[] l = new long[size];
    }

    private static void producesStackOverflowError() {
        runEndlessRecursion();
    }
    private static void runEndlessRecursion() {
        runEndlessRecursion();
    }
}
