package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl.FanCommandsImpl;

import java.util.Optional;

import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Command.Command;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.DeviceManager.FanManager;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices.Fan;

public abstract class FanCommand implements Command{
    
    private String id;

    public FanCommand(String id) {
        this.id = id;
    }

    protected Optional<Fan> getFan() {
        return Optional.ofNullable(FanManager.getInstance().getFan(id));
    }
}
