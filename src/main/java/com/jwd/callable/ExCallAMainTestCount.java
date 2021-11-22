package com.jwd.callable;

import com.jwd.ExternalSingleItemProcessor;
import com.jwd.Range;

public class ExCallAMainTestCount {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        countSumOfAndTest(Range.TOTAL, 0);
        System.out.println("END TIME :" + (System.currentTimeMillis() - startTime));
    }

    private static void countSumOfAndTest(long rangeLastIndex, long result) throws InterruptedException {
        long sum = 0;
        for (long l = 0; l < rangeLastIndex; l++) {
            sum = sum + l;
            ExternalSingleItemProcessor.processSingleItem(l);
        }
        System.out.println("TEST=" + sum);
        System.out.println("CORRECT=" + ((sum - result) == 0));
    }
}
