package com.jwd.sync;

public class MutexMain {
    private volatile int num = 5;

    private final Object mutex = new Object();

    public void doSomething() {
        // some sync logic
        synchronized (mutex) {
            // code, accessible only to one thread at a time
        }
    }

    public synchronized void doSomething(boolean isSync) {
        // code, accessible only to one thread at a time
    }
}
