package com.jwd.waitNotify;

public class ProducerConsumer {
    private boolean isReady;
    private Object object = null;

    public synchronized void consume() {
        while (!isReady) { // false
            try {
                wait(); // method produce will set isReady=true and notify us
                // process consume object
            } catch (Exception e) {}
        }
        object = null; // after object been consumed
        isReady = false;
    }

    public synchronized void produce() {
        object = new Object();
        isReady = true;
        notify();
    }
}
