package DesignPattern.BehavioralPatterns.MediatorAirTrafficControl;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.AirCraftsImpl.AirIndia;
import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.AirTrafficControllers.AirTrafficController;
import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.AirTrafficControllersImpl.MumbaiAirTrafficController;
import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.RunwayImpl.DomesticRunway;
import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.Runways.Runway;

public class Demo {
    public static void main(String[] args) {
        List<Runway> runways = Arrays.asList(new DomesticRunway(0), new DomesticRunway(1), new DomesticRunway(2));
        AirTrafficController atc = new MumbaiAirTrafficController(runways);
        ExecutorService landingService = Executors.newFixedThreadPool(5);
        landingService.execute(new AirIndia("AI_1230", atc));
        landingService.execute(new AirIndia("AI_1231", atc));
        landingService.execute(new AirIndia("AI_1232", atc));
        landingService.execute(new AirIndia("AI_1233", atc));
        landingService.execute(new AirIndia("AI_1234", atc));
        landingService.execute(new AirIndia("AI_1235", atc));
        landingService.execute(new AirIndia("AI_1236", atc));
        landingService.execute(new AirIndia("AI_1237", atc));
        landingService.execute(new AirIndia("AI_1238", atc));
        landingService.execute(new AirIndia("AI_1239", atc));
        landingService.execute(new AirIndia("AI_1240", atc));
        landingService.shutdown();
    }
}
