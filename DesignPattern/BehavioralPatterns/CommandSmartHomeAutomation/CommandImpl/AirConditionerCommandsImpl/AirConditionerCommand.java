package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl.AirConditionerCommandsImpl;

import java.util.Optional;

import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Command.Command;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.DeviceManager.AirConditionerManager;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices.AirConditioner;

public abstract class AirConditionerCommand implements Command{
    
    private String id;
    private int temperature;

    public AirConditionerCommand(String id) {
        this.id = id;
    }

    protected Optional<AirConditioner> getAC() {
        return Optional.ofNullable(AirConditionerManager.getInstance().getAirConditioner(id));
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
    }

    public int getTemperature() {
        return temperature;
    }

    
}
