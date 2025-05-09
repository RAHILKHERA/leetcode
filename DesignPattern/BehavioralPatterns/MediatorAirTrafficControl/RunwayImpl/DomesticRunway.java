package DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.RunwayImpl;

import java.util.concurrent.atomic.AtomicBoolean;

import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.Runways.Runway;

public class DomesticRunway implements Runway {

    private int runwayId;
    private AtomicBoolean occupied;
    
    public DomesticRunway(int runwayId) {
        this.runwayId = runwayId;
        occupied = new AtomicBoolean();
    }

    @Override
    public int getRunwayId() {
       return runwayId;
    }

    @Override
    public boolean isOccupied() {
       return occupied.get();
    }

    @Override
    public void changeOccupancy() {
      occupied.set(!isOccupied());
    }
    
}
