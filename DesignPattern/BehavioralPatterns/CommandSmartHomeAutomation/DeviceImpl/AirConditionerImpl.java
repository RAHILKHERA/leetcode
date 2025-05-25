package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.DeviceImpl;

import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices.AirConditioner;

public class AirConditionerImpl implements AirConditioner {

    private static final int MIN_TEMPERATURE = 0;
    private static final int MAX_TEMPERATURE = 30;

    private String id;
    private boolean isOn;
    private int temperature;

    public AirConditionerImpl(String airConditionerId) {
        this.id = airConditionerId;
        isOn = false;
        temperature = 0;
    }

    @Override
    public void powerOn() {
        if (!isOn) {
            isOn = true;
            temperature = 24;
            System.out.println("Started AC " + id + " at temperature " + temperature);
        } else {
            System.out.println("AC " + id + " is already running and temperature is set to " + temperature);
        }
    }

    @Override
    public void powerOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Powering Off AC " + id);
        } else {
            System.out.println("AC " + id + " is already off.");
        }
    }

    @Override
    public void setTemperature(int temp) {
        if (isOn) {
            if (temp >= MIN_TEMPERATURE && temp <= MAX_TEMPERATURE) {
                System.out.println("AC " + id + " setting  temperature to " + temp);
                this.temperature = temp;
            } else {
                System.out.println("AC " + id + " cannot set the temperature. Temperature out of range.");
            }
        } else {
            System.out.println("AC " + id + " is off. Cannot set the temperature.");
        }
    }

    @Override
    public int getTemperature() {
        return temperature;
    }

}
