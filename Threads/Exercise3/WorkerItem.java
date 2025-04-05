package Threads.Exercise3;

import java.util.concurrent.locks.Lock;

public class WorkerItem implements Runnable {

    private SharedResource sharedResource;
    private Lock lock;
    private static final int NUM_ITERATIONS = 10;

    WorkerItem(SharedResource sharedResource, Lock lock) {
        this.sharedResource = sharedResource;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            lock.lock();
            try {
                sharedResource.incrementSharedResource();
            } finally {
                lock.unlock();
            }
        }
    }
}
