package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices;

public interface AirConditioner {
    public void powerOn();
    public void powerOff();

    public void setTemperature(int temp);

    public int getTemperature();
}
