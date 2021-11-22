package com.jwd.simple;

public class ExRunnable implements Runnable {

    @Override
    public void run() {
        rumMyCode();
    }

    private void rumMyCode() {

        try {
            for (int i = 0; i < 5; i++) {

                System.out.println("ExRunnable --->" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                throw new RuntimeException();
            }
        } finally {
            System.out.println("DONE. ExRunnable. name: " + Thread.currentThread().getName());
        }
    }
}
