package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl.AirConditionerCommandsImpl;

import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices.AirConditioner;

public class SetTemperature extends AirConditionerCommand {

    private int previousTemperature;

    public SetTemperature(String id) {
        super(id);
    }

    @Override
    public void execute() {
        getAC().ifPresentOrElse((AirConditioner ac) -> {
            previousTemperature = ac.getTemperature();
            ac.setTemperature(super.getTemperature());
        }, () -> System.out.println("AC not found"));
    }

    @Override
    public void undo() {
        getAC().ifPresentOrElse((AirConditioner ac) -> {
            ac.setTemperature(previousTemperature);
            previousTemperature = super.getTemperature();
        }, () -> System.out.println("AC not found"));
    }

    public void setTemperature(int temperature) {
        super.setTemperature(temperature);
    }
    
}
