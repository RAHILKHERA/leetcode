package Threads.Exercise2;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

    private int BUFFER_SIZE;
    private Queue<Integer> buffer;

    Buffer(int size) {
        BUFFER_SIZE = size;
        buffer = new LinkedList<>();
    }

    public void write(int value) {
        if (isFull()) {
            throw new RuntimeException("Buffer Full.");
        }
        buffer.offer(value);
    }

    public int read() {
        if (isEmpty()) {
            throw new RuntimeException("Buffer Empty.");
        }
        return buffer.poll();
    }

    public synchronized boolean isEmpty() {
        return buffer.isEmpty();
    }

    public synchronized boolean isFull() {
        return buffer.size() == BUFFER_SIZE;
    }
}
