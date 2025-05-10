package DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.Runways;

public interface Runway {
    public int  getRunwayId();
    public boolean isOccupied();
    public void changeOccupancy();
}
