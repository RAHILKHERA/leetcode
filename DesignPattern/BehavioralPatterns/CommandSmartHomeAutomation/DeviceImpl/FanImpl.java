package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.DeviceImpl;

import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices.Fan;

public class FanImpl implements Fan {

    private static final int MAX_SPEED = 25;
    
    private String id;
    private boolean isOn;
    private int speed;
   
    public FanImpl(String fanId) {
        id = fanId;
        isOn = false;
        speed = 0;
    }

    public String getId() {
        return id;
    }

    @Override
    public void start() {
        if (!isOn) {
            isOn = true;
            speed = 5;
            System.out.println("Started fan " + id + " at speed " + speed);
        } else {
            System.out.println("Fan " + id + " is already running at  " + speed);
        }
    }

    @Override
    public void stop() {
        if (isOn) {
            isOn = false;
            speed = 0;
            System.out.println("Stopping fan " + id );
        } else {
            System.out.println("Fan " + id + " is already stopped ");
        }
    }

    @Override
    public void increaseSpeed() {
        if (isOn) {
            if (speed == MAX_SPEED) {
                System.out.println("Fan " + id + " running at full speed. ");    
                return;
            }
            speed += 5;
            System.out.println("Fan " + id + " speed increased to " + speed);
        } else {
            System.out.println("Fan " + id + " is stopped. Cannot increase the speed.");
        }
    }

    @Override
    public void decreaseSpeed() {
        if (isOn) {
            speed -= 5;
            System.out.println("Fan " + id + " speed decresead to " + speed);
            if (speed == 0) {
                stop();
            }
        } else {
            System.out.println("Fan " + id + " is stopped. Cannot decrease the speed.");
        }
    }
    
}
