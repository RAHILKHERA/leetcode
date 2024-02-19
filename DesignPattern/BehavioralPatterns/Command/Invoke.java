package DesignPattern.BehavioralPatterns.Command;

import java.util.ArrayList;
import java.util.List;

public class Invoke {

    private List<Command> commands;

    Invoke() {
        commands = new ArrayList<>();
    }

    public void receiveCommands(Command command) {
        commands.add(command);
    }

    public void executeCommands() {

        new Thread(() -> {
            for (Command command : commands) {
                try {
                    Thread.sleep(1000);
                    command.execute();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();
    }

}
