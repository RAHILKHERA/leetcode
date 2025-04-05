package Threads.Exercise1;

public class IncrementThread implements Runnable {

    private Counter counter;
    private int incrementCounter;

    IncrementThread(Counter counter, int incrementCounter) {
        this.counter = counter;
        this.incrementCounter = incrementCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < incrementCounter; i++)
            counter.incrementCounter();
    }

}
