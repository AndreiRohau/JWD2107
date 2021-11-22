package com.jwd.forkJoinTask;

import com.jwd.ExternalSingleItemProcessor;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SumRecursiveTask extends RecursiveTask<Long> {
    public static final long THRESHOLD = 2;

    private List<Long> list;
    private int begin;
    private int end;

    public SumRecursiveTask(List<Long> list) {
        this(list, 0, list.size());
    }

    private SumRecursiveTask(List<Long> list, int begin, int end) {
        this.list = list;
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - begin;
        long result = 0;

        if (length <= THRESHOLD) {
            result = getResult(list, begin, end);
        } else {
            int middle = begin + length / 2;
            SumRecursiveTask taskLeft = new SumRecursiveTask(list, begin, middle);
            // run async
            taskLeft.fork();
            SumRecursiveTask taskRight = new SumRecursiveTask(list, middle, end);
            // run async
            taskRight.fork();

            long leftSum = taskLeft.join();
            long rightSum = taskRight.join();
            result = leftSum + rightSum;
        }

        return result;
    }

    public static long getResult(List<Long> list, int begin, int end) {
        long result = 0;
        for (int i = begin; i < end; i++) {
            Long item = list.get(i);
            process(item);
            result += item;
        }
        return result;
    }

    private static void process(Long item) {
        try {
            ExternalSingleItemProcessor.processSingleItem(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
