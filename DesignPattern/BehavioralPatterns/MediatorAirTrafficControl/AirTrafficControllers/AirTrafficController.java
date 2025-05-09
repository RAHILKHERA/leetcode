package DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.AirTrafficControllers;

import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.AirCraftsImpl.BaseAircraft;
import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.Exceptions.RunwayAllocationException;


public interface AirTrafficController {

    public void registerAirCraft(BaseAircraft airCraft);
    public void deRegisterAirCraft(BaseAircraft airCraft);
    public int requestLanding(BaseAircraft airCraft) throws RunwayAllocationException, InterruptedException;
    public void landingNotification(BaseAircraft airCraft) throws RunwayAllocationException, InterruptedException; 
}   