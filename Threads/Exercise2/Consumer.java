package Threads.Exercise2;

public class Consumer implements Runnable {
    private Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    try {
                        System.out.println("Consumer, Buffer is Empty");
                        buffer.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                int value = buffer.read();
                System.out.println("Consumer consumed : " + value);
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
