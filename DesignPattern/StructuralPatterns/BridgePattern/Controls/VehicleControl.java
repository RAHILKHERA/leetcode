package DesignPattern.StructuralPatterns.BridgePattern.Controls;

import DesignPattern.StructuralPatterns.BridgePattern.Directions;
import DesignPattern.StructuralPatterns.BridgePattern.Vehicles.Vehicle;

public abstract class VehicleControl {
    
    private Vehicle vehicle;

    public VehicleControl(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public abstract void start();
    public abstract void stop();
    public abstract void move(Directions dir);
    public abstract void increaseSpeed();
    public abstract void decreaseSpeed();
}
