package Threads.Exercise3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static final int NUM_THREADS = 10;

    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();
        Lock lock = new ReentrantLock(true);
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new WorkerItem(sharedResource, lock));
            threads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].join();
        }

        System.out.println("Shared Resource : " + sharedResource.getSharedResource());
    }
}
