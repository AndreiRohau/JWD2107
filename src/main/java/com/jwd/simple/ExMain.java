package com.jwd.simple;

public class ExMain {

    private int localMain = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread exThread = new ExThread("ExTHREAD!!!!");
        Runnable runnable = new ExRunnable();
        Thread exRunnable = new Thread(runnable, "ExRUNNABLE!!!!!!!");

        runnable.run();
        // we also can prioritize threads
        exThread.setPriority(Thread.MAX_PRIORITY);
        exRunnable.setPriority(Thread.MIN_PRIORITY);

        exThread.start();
        exRunnable.start();
        System.out.println(exThread.getState());
        System.out.println(exRunnable.getState());
        System.out.println("===== WE ARE HERE");
        Thread.sleep(1000);
        System.out.println("===== WE ARE AND HERE");
        System.out.println("===== WE ARE AND HERE NOW");
        System.out.println("===== WE ARE AND HERE NOW AGAIN");
        System.out.println("===== WE ARE AND HERE NOW AGAIN STAND");
        System.out.println("===== WE ARE AND HERE NOW AGAIN STAND STILL");
    }
}
