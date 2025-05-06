package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl.AirConditionerCommandsImpl;

import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices.AirConditioner;

public class PowerOffAC  extends AirConditionerCommand {
    
    public PowerOffAC(String id) {
        super(id);
    }

    @Override
    public void execute() {
        getAC().ifPresentOrElse((AirConditioner ac) -> ac.powerOff(),
                () -> System.out.println("Air Conditioner not available."));
    }

    @Override
    public void undo() {
        getAC().ifPresentOrElse((AirConditioner ac) -> ac.powerOn(),
                () -> System.out.println("Air Conditioner not available."));
    }
}
