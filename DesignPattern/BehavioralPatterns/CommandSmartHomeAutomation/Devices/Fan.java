package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices;

public interface Fan {

    public String getId();
    public void start();
    public void stop();
    public void increaseSpeed();
    public void decreaseSpeed();
} 