package com.jwd.waitNotify;

import java.util.concurrent.TimeUnit;

public class MainB {
    public static void main(String[] args) {
        final Payment payment = new Payment();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> payment.doPay()).start();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        payment.init();
    }
}
