package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.DeviceManager;

import java.util.HashMap;
import java.util.Map;

import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.DeviceImpl.AirConditionerImpl;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices.AirConditioner;

public class AirConditionerManager {
    private Map<String, AirConditioner> airConditioners;
    private static AirConditionerManager INSTANCE;

    private AirConditionerManager () {
        airConditioners = new HashMap<>();
    }

    public static AirConditionerManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AirConditionerManager();
        }
        return INSTANCE;
    }

    public void addAirConditioner(String id) {
        airConditioners.put(id, new AirConditionerImpl(id));
    }

    public void deleteAirConditioner(String id) {
        airConditioners.remove(id);
    }

    public AirConditioner getAirConditioner(String id) {
        return airConditioners.getOrDefault(id, null);
    }
}
