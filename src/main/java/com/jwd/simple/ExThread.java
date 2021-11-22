package com.jwd.simple;

public class ExThread extends Thread {
    private int local = 0;

    public ExThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        rumMyCode();
    }

    private void rumMyCode() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("ExThread =" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            System.out.println("DONE. ExThread. name: " + Thread.currentThread().getName());
        }
    }
}
