package Threads.Exercise2;

/**
 * Write a Java program to create a producer-consumer scenario using the wait()
 * and notify() methods for thread synchronization.
 */
public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));
        producerThread.start();
        consumerThread.start();
    }
}