package DesignPattern.StructuralPatterns.BridgePattern.ControlImpl;

import DesignPattern.StructuralPatterns.BridgePattern.Controls.VehicleControl;
import DesignPattern.StructuralPatterns.BridgePattern.Vehicles.Vehicle;
import DesignPattern.StructuralPatterns.BridgePattern.Directions;

public class AdvancedControl extends VehicleControl {

  

    public AdvancedControl(Vehicle vehicle) {
        super(vehicle);    
    }

    @Override
    public void start() {
        System.out.println("Advanced Control:");
        getVehicle().startEngine();
    }

    @Override
    public void stop() {
        System.out.println("Advanced Control:");
        getVehicle().stopEngine();
    }

    @Override
    public void move(Directions dir) {
        System.out.println("Advanced Control:");
        getVehicle().move(dir);
    }

    @Override
    public void increaseSpeed() {
        System.out.println("Advanced Control:");
        getVehicle().accelerate();
    }

    @Override
    public void decreaseSpeed() {
        System.out.println("Advanced Control:");
        getVehicle().brake();
    }

    // 🚀 Extra Advanced Features
    public void enableSelfParking() {
        System.out.println("Activating Self-Parking Mode...");
    }

    public void enableCruiseControl() {
        System.out.println("Activating Cruise Control...");
    }
}
