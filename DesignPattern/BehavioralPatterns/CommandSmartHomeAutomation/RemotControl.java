package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation;

import java.util.ArrayList;
import java.util.List;

import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Command.Command;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Command.CommandManager;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl.MacroCommandImpl;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl.AirConditionerCommandsImpl.PowerOnAC;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl.AirConditionerCommandsImpl.SetTemperature;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl.FanCommandsImpl.IncreaseFanSpeed;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl.FanCommandsImpl.TurnOnFan;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl.LightCommandsImpl.TurnOffLight;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl.LightCommandsImpl.TurnOnLight;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.DeviceManager.AirConditionerManager;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.DeviceManager.FanManager;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.DeviceManager.LightManager;

public class RemotControl {
    
    public void registerDevices() {
        FanManager.getInstance().addFan("Living Room Fan 1");
        FanManager.getInstance().addFan("Living Room Fan 2");
        FanManager.getInstance().addFan("Bed Room 1 Fan");
        AirConditionerManager.getInstance().addAirConditioner("BedRoom 1 AirConditioner");
        AirConditionerManager.getInstance().addAirConditioner("BedRoom 2 AirConditioner");
        LightManager.getInstance().addLight("Living Room Light 1");
        LightManager.getInstance().addLight("BedRoom 1 Light 1");
        LightManager.getInstance().addLight("BedRoom 1 Light 2");
        LightManager.getInstance().addLight("BedRoom 2 Light 1");
    }

    public static void main(String[] args) throws InterruptedException {
        RemotControl remotControl = new RemotControl();
        remotControl.registerDevices();

        CommandManager manager = new CommandManager();
        manager.executeCommand(new TurnOnFan("Living Room Fan 1"));
        manager.executeCommand(new IncreaseFanSpeed("Living Room Fan 1"));
        manager.executeCommand(new TurnOnLight("Living Room Light 1"));

        Thread.sleep(1000);

        manager.undo();
        manager.undo();
        
        MacroCommandImpl goodNight = new MacroCommandImpl();

        List <Command> commands = new ArrayList<>();
        commands.add(new TurnOffLight("BedRoom 1 Light 1"));
        commands.add(new TurnOffLight("BedRoom 1 Light 2"));
        commands.add(new PowerOnAC("BedRoom 1 AirConditioner"));
        SetTemperature setACTemperature = new SetTemperature("BedRoom 1 AirConditioner");
        setACTemperature.setTemperature((byte) 22);
        commands.add(setACTemperature);
        commands.add(new TurnOnFan("Bed Room 1 Fan"));
        
        goodNight.addMacroCommand(commands);
        goodNight.execute();

        goodNight.undo();
      
    }
}
