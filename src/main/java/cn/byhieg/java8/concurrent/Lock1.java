package cn.byhieg.java8.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author Benjamin Winterberg
 */
public class Lock1 {

    private static final int NUM_INCREMENTS = 10000;

    private static ReentrantLock lock = new ReentrantLock();

    private static int count = 0;
    private static int count1 = 0;

    private static void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    private static void increment1() {
            count1++;
    }

    public static void main(String[] args) {
        testLock();
    }

    private static void testLock() {
        count = 0;

        ExecutorService executor = Executors.newFixedThreadPool(3);

        IntStream.range(0, NUM_INCREMENTS)
                 .forEach(i -> executor.submit(Lock1::increment));

        IntStream.range(0, NUM_INCREMENTS)
                 .forEach(i -> executor.submit(Lock1::increment1));


        ConcurrentUtils.stop(executor);

        System.out.println(count);
        System.out.println(count1);
    }

}
