package DesignPattern.BehavioralPatterns.Command;

public class Client {

    public static void main(String[] args) {

        Receiver receiver = new Receiver(1);

        Operation1Command command1 = new Operation1Command(receiver);
        Operation2Command command2 = new Operation2Command(receiver);

        Invoke invoke = new Invoke();

        for (int i = 0; i < 10; i++) {
            invoke.receiveCommands(command1);
            invoke.receiveCommands(command2);
        }

        invoke.executeCommands();
    }
}
