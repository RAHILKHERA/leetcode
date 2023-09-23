package Thread;

class Hi implements Runnable{

    public void run () {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Hello implements Runnable {

    public void run () {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class RunnableInterfaceDemo {

    public static void main(String[] args) {
        
        Runnable obj1 = new Hi();
        Runnable obj2 = new Hello();

        // obj1.show();
        // obj2.show();

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
    }
}
