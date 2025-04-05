package Threads.Exercise2;

public class Producer implements Runnable {

    private Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int value = 0;
        while (true) {

            synchronized (buffer) {
                while (buffer.isFull()) {
                    try {
                        System.out.println("Producer, buffer is full.");
                        buffer.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("Producer produced : " + value);
                buffer.write(value++);
                buffer.notifyAll();
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
