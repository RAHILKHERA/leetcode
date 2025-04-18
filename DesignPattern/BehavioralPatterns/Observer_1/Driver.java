package DesignPattern.BehavioralPatterns.Observer_1;

public class Driver {
    public static void main(String[] args) {

        WeatherStation ws = new WeatherStation();
        PhoneDisplay pd = new PhoneDisplay();
        WindowDisplay wd = new WindowDisplay();

        ws.addWeatherChangeListener(pd);
        ws.addWeatherChangeListener(wd);

        ws.setTemperature(10);
        ws.setTemperature(15);
    }
}
