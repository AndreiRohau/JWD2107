package com.jwd.lock;

import com.jwd.schedule.TimerMain;

import java.util.concurrent.TimeUnit;

public class PaymentLockMain {
    public static void main(String[] args) {
        final PaymentLock paymentLock = new PaymentLock();
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                paymentLock.doPayment();
            }
        });
        thread.start();
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        paymentLock.deposit();
        System.out.println("MAIN END");
    }
}
