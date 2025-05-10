package DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.AirCrafts;

import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.RunwayStatus;
import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.AirTrafficControllers.AirTrafficController;
import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.Exceptions.RunwayAllocationException;


public interface AircraftInterface extends Runnable {
    public void registerAirTrafficController(AirTrafficController atc);
    public RunwayStatus requestLanding() throws RunwayAllocationException,  InterruptedException;  
} 