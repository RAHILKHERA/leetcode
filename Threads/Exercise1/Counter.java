package Threads.Exercise1;

public class Counter {

    private int count = 0;

    public synchronized void incrementCounter() {
        count++;
    }

    public int getCounter() {
        return count;
    }
}
