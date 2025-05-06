package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.DeviceManager;

import java.util.HashMap;
import java.util.Map;

import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.DeviceImpl.LightImpl;
import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices.Light;

public class LightManager {
    private Map<String, Light> lights;
    private static LightManager INSTANCE;

    private LightManager() {
        lights = new HashMap<>();
    }

    public static LightManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LightManager();
        }
        return INSTANCE;
    }

    public void addLight(String id) {
        lights.put(id, new LightImpl(id));
    }

    public void deleteLight (String id) {
        lights.remove(id);
    }

    public Light getLight(String id) {
        return lights.getOrDefault(id, null);
    }
    
}
