package com.jwd.waitNotify;

import java.util.Scanner;

public class Payment {
    private int amount;

    public synchronized void doPay() {
        try {
            System.out.println("Payment START");

            if (amount <= 0) {
                this.wait();
            }
            // process payment
            System.out.println("Payment amount=" + amount);
        } catch (Exception e) {}
        System.out.println("Payment END");
    }

    public synchronized void init() {
        System.out.println("Init START");
        amount = new Scanner(System.in).nextInt();
        this.notifyAll();
    }
}
