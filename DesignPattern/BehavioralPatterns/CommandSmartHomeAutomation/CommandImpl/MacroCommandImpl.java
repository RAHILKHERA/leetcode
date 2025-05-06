package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Command.Command;

public class MacroCommandImpl implements Command {

    private final  List<Command> commands = new ArrayList<>();

    public void addMacroCommand(List<Command> commands) {
        this.commands.addAll(commands);
    }


    @Override
    public void execute() {
        for (Command cmd : commands) {
            cmd.execute();
        }
    }

    @Override
    public void undo() {
        ListIterator<Command> listIterator = commands.listIterator();
        while (listIterator.hasPrevious()) {
            listIterator.previous().undo();
        }
    }
    
}
