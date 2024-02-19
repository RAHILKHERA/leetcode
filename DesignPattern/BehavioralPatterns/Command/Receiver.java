package DesignPattern.BehavioralPatterns.Command;

public class Receiver {

    private int receiverId;

    Receiver(int receiverId) {
        this.receiverId = receiverId;
    }

    public void performOperation1() {
        System.out.println("Receiver :: Perform Operation1 :: " + receiverId);
    }

    public void performOperation2() {
        System.out.println("Receiver :: Perform Operation2 :: " + receiverId);
    }
}
