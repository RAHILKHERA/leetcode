package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices;

public interface Light {
    public String getId();
    public void turnOn();
    public void turnOff();
    public boolean isOn();
}
