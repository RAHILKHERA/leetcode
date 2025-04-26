package DesignPattern.StructuralPatterns.BridgePattern.ControlImpl;

import DesignPattern.StructuralPatterns.BridgePattern.Directions;
import DesignPattern.StructuralPatterns.BridgePattern.Controls.VehicleControl;
import DesignPattern.StructuralPatterns.BridgePattern.Vehicles.Vehicle;

public class AutoPilotControl extends VehicleControl{

    
   
    public AutoPilotControl(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void start() {
       System.out.println("AutoPilot Control : ");
       getVehicle().startEngine();
    }

    @Override
    public void stop() {
        System.out.println("AutoPilot Control : ");
        getVehicle().stopEngine();
    }

    @Override
    public void move(Directions dir) {
        System.out.println("AutoPilot Control : ");
        getVehicle().move(dir);
    }

    @Override
    public void increaseSpeed() {
        System.out.println("AutoPilot Control : ");
        getVehicle().accelerate();
    }

    @Override
    public void decreaseSpeed() {
        System.out.println("AutoPilot Control : ");
        getVehicle().brake();
    }
    
}
