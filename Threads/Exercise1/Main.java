package Threads.Exercise1;

/**
 * Write a Java program to create and start multiple threads that increment a
 * shared counter variable concurrently.
 */

public class Main {

    private static int THREADS = 10;
    private static int INCREMENT_PER_THREAD = 10;

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Thread[] threads = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(new IncrementThread(counter, INCREMENT_PER_THREAD));
            threads[i].start();
        }

        for (int i = 0; i < THREADS; i++) {
            threads[i].join();
        }

        System.out.println("Value of Counter : " + counter.getCounter());
    }
}
