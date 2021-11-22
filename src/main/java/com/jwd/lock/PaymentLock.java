package com.jwd.lock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PaymentLock {
    private int amount;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    public void doPayment() {
        try {
            System.out.println("Start payment lock");
            lock.lock();
            while (amount <= 0) {
                condition.await();
            }
            // payment code here
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("doPayment is closed");
        }
    }

    public void deposit() {
        try {
            lock.lock();
            System.out.println("Depo amount");
            amount = new Scanner(System.in).nextInt();
        } finally {
            condition.signal();
            lock.unlock();
            System.out.println("deposit is closed");
        }
    }
}
