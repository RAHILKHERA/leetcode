package DesignPattern.StructuralPatterns.BridgePattern.ControlImpl;

import DesignPattern.StructuralPatterns.BridgePattern.Directions;
import DesignPattern.StructuralPatterns.BridgePattern.Controls.VehicleControl;
import DesignPattern.StructuralPatterns.BridgePattern.Vehicles.Vehicle;

public class ManualControl extends VehicleControl{
    
   
    public  ManualControl(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void start() {
       System.out.println("Manual Control : ");
       getVehicle().startEngine();
    }

    @Override
    public void stop() {
        System.out.println("Manual Control : ");
        getVehicle().stopEngine();
    }

    @Override
    public void move(Directions dir) {
        System.out.println("Manual Control : ");
        getVehicle().move(dir);
    }

    @Override
    public void increaseSpeed() {
        System.out.println("Manual Control : ");
        getVehicle().accelerate();
    }

    @Override
    public void decreaseSpeed() {
        System.out.println("Manual Control : ");
        getVehicle().brake();
    }
}
