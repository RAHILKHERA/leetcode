package DesignPattern.StructuralPatterns.FacadePattern.HomeTheaterSystem;

import java.util.ArrayList;
import java.util.List;

public class Lights {
    
    List<String> lightIds;
    
    public Lights (List<String> lightIds) {
        this.lightIds = new ArrayList<>(lightIds);
    }

    public void on() {
        for (String lightId : lightIds) {
            System.out.println("Switching On : " + lightId);
        }
    }

    public void dim() {
        for (String lightId : lightIds) {
            System.out.println("Dimming Light : " + lightId);
        }
    }

    
    public void off() {
        for (String lightId : lightIds) {
            System.out.println("Switching Off : " + lightId);
        }
    }
}
