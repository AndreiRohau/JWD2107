package com.jwd.callable;

import com.jwd.ExternalSingleItemProcessor;

import java.util.List;
import java.util.concurrent.Callable;

public class ExCallA implements Callable<Long> {

    private static int callablesStarted = 0;
    private int callablesId;

    private final List<Long> longs;

    public ExCallA(List<Long> longs) {
        incrementAmount();
        System.out.println("INITS : " + Thread.currentThread().getName() + ". callablesId=" + callablesId);
        this.longs = longs;
    }

    private synchronized void incrementAmount() {
        callablesStarted++;
        this.callablesId = callablesStarted;
    }

    @Override
    public Long call() throws Exception {
        System.out.println("PROCESS : " + Thread.currentThread().getName() + ". callablesId=" + callablesId);
        long sum = 0L;
        // process each passed object to thread
        for (Long l : longs) {
            ExternalSingleItemProcessor.processSingleItem(l);
            sum = sum + l;
        }
        System.out.println("DONE : [" + Thread.currentThread().getName() + "]"  + ". callablesId=" + callablesId + " result=" + sum);
        return sum;
    }
}
