package DesignPattern.BehavioralPatterns.Observer_1;

import java.beans.PropertyChangeListener;

public interface Display extends PropertyChangeListener {
    public void update(int temp);
}
