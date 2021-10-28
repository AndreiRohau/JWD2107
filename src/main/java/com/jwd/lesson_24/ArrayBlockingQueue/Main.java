package com.jwd.lesson_24.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        BlockingQueue<String> arrayBlockingQueuePool = new ArrayBlockingQueue<>(10);
        BlockingQueue<String> arrayBlockingQueueTaken = new ArrayBlockingQueue<>(10);

        // for connection pool
        arrayBlockingQueue.add(""); // add - w\o + throws exception
        // for connection pool
        arrayBlockingQueue.offer(""); // offer - w\o + false
        arrayBlockingQueue.put(""); // put - w\o + waiting
        arrayBlockingQueue.offer("", 10, TimeUnit.SECONDS); // offer - w\o + waiting custom time


        arrayBlockingQueue.peek(); // get w\o deleting from queue
        arrayBlockingQueue.poll(); // get + null

        // for connection pool
        arrayBlockingQueue.take(); // get - waiting
        // for connection pool
        arrayBlockingQueue.poll(10, TimeUnit.SECONDS); // get - waiting custom time

    }
}
