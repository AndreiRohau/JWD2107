package com.jwd.waitNotify;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class MainA {
    Object o;

    public static void main(String[] args) {
        final Payment payment = new Payment();
        new Thread(() -> payment.doPay()).start();

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        payment.init();
    }
}
