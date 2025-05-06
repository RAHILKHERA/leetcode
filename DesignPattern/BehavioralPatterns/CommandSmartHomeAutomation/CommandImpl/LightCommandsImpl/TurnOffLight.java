package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl.LightCommandsImpl;

import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices.Light;

public class TurnOffLight extends LightCommand{

    public TurnOffLight(String id) {
        super(id);
    }

     @Override
    public void execute() { 
        getLight().ifPresentOrElse((Light light) -> light.turnOff(),
                () -> System.out.println("Light is not available"));

    }

    @Override
    public void undo() {
        getLight().ifPresentOrElse((Light light) -> light.turnOn(),
        () -> System.out.println("Light is not available"));
    }
}
