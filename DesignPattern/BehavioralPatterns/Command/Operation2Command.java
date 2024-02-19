package DesignPattern.BehavioralPatterns.Command;

public class Operation2Command implements Command {

    private Receiver receiver;

    Operation2Command(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.performOperation2();
    }

}
