package DesignPattern.BehavioralPatterns.Observer_1;

import java.beans.PropertyChangeEvent;

public class PhoneDisplay implements Display {

    private int temperature;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        update((int) evt.getNewValue());
    }

    @Override
    public void update(int temp) {
        temperature = temp;
        System.out.println("Phone Display : Temperature updated to " + temperature);
    }

}
