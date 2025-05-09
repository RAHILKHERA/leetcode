package DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.AirCraftsImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.RunwayStatus;
import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.AirCrafts.AircraftInterface;
import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.AirTrafficControllers.AirTrafficController;
import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.Exceptions.RunwayAllocationException;

public abstract class BaseAircraft implements AircraftInterface {
    private final static Logger LOGGER =  Logger.getLogger(BaseAircraft.class.getName()); 
    private AirTrafficController atc;
    private String airCraftId;
    private boolean landed;

    public BaseAircraft(String airCraftId) {
        setAirCraftId(airCraftId);
    }

    public BaseAircraft(String airCraftId, AirTrafficController atc) {
        this.airCraftId = airCraftId;
        registerAirController(atc);
    }

    public String getAirCraftId() {
        return airCraftId;
    }

    protected void setAirCraftId(String airCraftId) {
        this.airCraftId = airCraftId;
    }

    public void registerAirController(AirTrafficController atc) {
        this.atc = atc;
    }

    protected AirTrafficController getTrafficController() {
        return atc;
    }

    protected boolean isLanded() {
        return landed;
    }

    protected  void setLanded(boolean isLanded) {
       landed = isLanded;
    }

     @Override
    public void run() {
        getTrafficController().registerAirCraft(this);
        while (!isLanded()) {
            try {
                RunwayStatus status = requestLanding();
                if (status.equals(RunwayStatus.AVAILABLE)) {
                    //Simulate landing.
                    Thread.sleep((long) (Math.random() * 1000));
                    getTrafficController().landingNotification(this);
                } else {
                    /*
                     * If runway is not available wait for 100 milli seconds before next request. 
                     * Unlike general cases, there cannot be maximum tries limit in this case. 
                     */

                    Thread.sleep(100);
                }
            } catch (RunwayAllocationException e) {
              LOGGER.log(Level.SEVERE, "AirIndia, Runway allocation failed for " + getAirCraftId() + "due to " + e.getMessage());  
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, "AirIndia, Landing retry interrupted " + getAirCraftId() + "due to " + e.getMessage());
            }
        }
        getTrafficController().deRegisterAirCraft(this);
    }

    protected abstract void landing(int runwayId);
}
