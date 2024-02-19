package DesignPattern.BehavioralPatterns.Command;

public class Operation1Command implements Command {

    private Receiver receiver;

    Operation1Command(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.performOperation1();
    }

}
