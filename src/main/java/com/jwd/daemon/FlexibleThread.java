package com.jwd.daemon;

import java.util.concurrent.TimeUnit;

public class FlexibleThread extends Thread {
    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            if (isDaemon()) {
                System.out.println("start daemon");

                TimeUnit.MILLISECONDS.sleep(100);
            } else {
                System.out.println("start normal");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (isDaemon()) {
                System.out.println("end daemon");
            } else {
                System.out.println("end normal");
            }
        }
    }
}
