package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl.LightCommandsImpl;

import java.util.Optional;

import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Command.Command;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.DeviceManager.LightManager;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices.Light;

public abstract class LightCommand implements Command {
  
    private String id;

    public LightCommand(String id) {
        this.id = id;
    } 

    protected Optional<Light> getLight() {
        return Optional.ofNullable(LightManager.getInstance().getLight(id));
    }

}
