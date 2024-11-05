package Concurrency.LeetCode_1491;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {

    private static int counter = 0;
    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        optimisticLocking();
        // pessimisticLocking();
    }

    private static void optimisticLocking() throws InterruptedException {

        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {

                int localCounter = 0;

                do {
                    localCounter = count.get();
                } while (!count.compareAndSet(localCounter, localCounter + 1));

            });
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Starting " + count.get());
    }

    private static void pessimisticLocking() throws InterruptedException {
        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {

                lock.lock();

                try {
                    System.out.println("Running Thread Counter = " + counter);
                    counter++;
                } catch (Exception e) {
                    System.out.println("Exception occured while accessing counter" + e.getMessage());
                    throw e;
                } finally {
                    lock.unlock();
                }

            });

            threads[i].setName("Thread " + i);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Starting");
    }

}
