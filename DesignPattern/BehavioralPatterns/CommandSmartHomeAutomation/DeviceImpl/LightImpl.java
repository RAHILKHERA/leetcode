package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.DeviceImpl;

import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices.Light;

public class LightImpl implements Light{
    
    private boolean isOn;
    private String id;

    public LightImpl(String lightId ) {
        id = lightId;
        isOn = false;
    }

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Light " + id + " is "  + isOn);    
        } else {
            System.out.println("Light " + id + " is already On.");    
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Light " + id + " is " + isOn);    
        } else {
            System.out.println("Light " + id + " is already Off.");
        }
        
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public String getId() {
        return id;
    }


}
