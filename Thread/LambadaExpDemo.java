package Thread;

public class LambadaExpDemo {

    public static void main(String[] args) {
        
        // Runnable obj1 = new Runnable() {
        //     public void run () {
        //         for (int i = 0; i < 5; i++) {
        //             System.out.println("Hi");
        //             try {
        //                 Thread.sleep(500);
        //             } catch (Exception e) {
        //                 e.printStackTrace();
        //             }
        //         }
        //     }
        // };
        // Runnable obj2 = new Runnable() {
        //     public void run () {
        //         for (int i = 0; i < 5; i++) {
        //             System.out.println("Hello");
        //             try {
        //                 Thread.sleep(500);
        //             } catch (Exception e) {
        //                 e.printStackTrace();
        //             }
        //         }
        //     }
        // };

        // obj1.show();
        // obj2.show();

        // Thread t1 = new Thread(new Runnable() {
        //     public void run () {
        //         for (int i = 0; i < 5; i++) {
        //             System.out.println("Hi");
        //             try {
        //                 Thread.sleep(500);
        //             } catch (Exception e) {
        //                 e.printStackTrace();
        //             }
        //         }
        //     }
        // });
        // Thread t2 = new Thread(new Runnable() {
        //     public void run () {
        //         for (int i = 0; i < 5; i++) {
        //             System.out.println("Hello");
        //             try {
        //                 Thread.sleep(500);
        //             } catch (Exception e) {
        //                 e.printStackTrace();
        //             }
        //         }
        //     }
        // });

        Thread t1 = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Hi");
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
         );


        Thread t2 = new Thread(() -> {
            
                for (int i = 0; i < 5; i++) {
                    System.out.println("Hello");
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            
        });


        t1.start();
        t2.start();
    }
}
