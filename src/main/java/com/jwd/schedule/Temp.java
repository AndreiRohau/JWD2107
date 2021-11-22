package com.jwd.schedule;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Temp extends TimerTask {
    private static int id = 0;
    @Override
    public void run() {
        System.out.print("id=" + ++id + "=");
        try {
            for(int i = 0; i < 5; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.print(" " + (i + 1));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" =END");
    }
}
