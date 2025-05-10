package DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.AirCraftsImpl;

import java.util.logging.Logger;

import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.RunwayStatus;
import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.AirTrafficControllers.AirTrafficController;
import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.Exceptions.RunwayAllocationException;

public class AirIndia extends BaseAircraft {

    private final static Logger LOGGER = Logger.getLogger(AirIndia.class.getSimpleName());

    public AirIndia(String airIndiaId) {
        super(airIndiaId);
    }

    public AirIndia(String airIndiaId, AirTrafficController atc) {
        super(airIndiaId, atc);
    }

    @Override
    public void registerAirTrafficController(AirTrafficController atc) {
        super.registerAirController(atc);
    }

    @Override
    public RunwayStatus requestLanding() throws RunwayAllocationException, InterruptedException {
        int runwayId = getTrafficController().requestLanding(this);
        if (runwayId == -1) {
            System.out.println("No runaway is available, Retry landing for Aircraft " + getAirCraftId());
            return RunwayStatus.NOT_AVAILABLE;
        }

        landing(runwayId);
        return RunwayStatus.AVAILABLE;
    }

    @Override
    public void landing(int runwayId) {
        LOGGER.info("Landing AirIndia aircraft, " + getAirCraftId() + " on runway " + runwayId);
        setLanded(true);
    }

   

}
