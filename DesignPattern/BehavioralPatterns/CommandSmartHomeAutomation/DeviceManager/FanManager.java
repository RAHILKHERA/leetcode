package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.DeviceManager;

import java.util.HashMap;
import java.util.Map;

import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.DeviceImpl.FanImpl;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices.Fan;

public class FanManager {
    private Map<String, Fan> fans;
    private static FanManager INSTANCE;
    private FanManager() {
        fans = new HashMap<>();
    }

    public static FanManager getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        INSTANCE = new FanManager();
        return INSTANCE;
    }

    public void addFan(String id) {
        fans.put(id, new FanImpl(id));
    }

    public void delteFan(String id) {
        fans.remove(id);
    }

    public Fan getFan(String id) {
        return fans.getOrDefault(id, null);
    }

}
