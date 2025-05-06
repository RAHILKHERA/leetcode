package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl.FanCommandsImpl;

import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices.Fan;

public class TurnOnFan extends FanCommand {

    public TurnOnFan(String id) {
        super(id);
    }

    @Override
    public void execute() {
        getFan().ifPresentOrElse((Fan fan) -> fan.start(), () -> System.out.println("Fan not found"));
    }

    @Override
    public void undo() {
        getFan().ifPresentOrElse((Fan fan) -> fan.stop(), () -> System.out.println("Fan not found"));
    }
}
