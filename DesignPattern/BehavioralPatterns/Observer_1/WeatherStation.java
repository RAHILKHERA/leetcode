package DesignPattern.BehavioralPatterns.Observer_1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WeatherStation {

    private PropertyChangeSupport weathChangeSupport;
    private int temperature;
    private static final String TEMPERATURE_CHANGE = "TEMPERATUR_CHANGE";

    public WeatherStation() {
        weathChangeSupport = new PropertyChangeSupport(this);
    }

    public void addWeatherChangeListener(PropertyChangeListener listener) {
        weathChangeSupport.addPropertyChangeListener(listener);
    }

    public void removeWeatherChangeListener(PropertyChangeListener listener) {
        weathChangeSupport.removePropertyChangeListener(listener);

    }

    public void setTemperature(int temp) {
        int oldTemp = this.temperature;
        this.temperature = temp;
        weathChangeSupport.firePropertyChange(TEMPERATURE_CHANGE, oldTemp, temp);
    }
}