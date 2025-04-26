package DesignPattern.StructuralPatterns.BridgePattern.VehicleImpl;

import DesignPattern.StructuralPatterns.BridgePattern.Directions;
import DesignPattern.StructuralPatterns.BridgePattern.Vehicles.Vehicle;

public class Truck implements Vehicle {
    @Override
    public void startEngine() {
       System.out.println("Starting Truck Engine.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping Truck Engine.");
    }

    @Override
    public void move(Directions dir) {
       System.out.println("Moving Truck in " + dir.getDirection() + " direction.");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating Truck Speed.");
    }

    @Override
    public void brake() {
       System.out.println("Reducing Truck Speed");
    }
    
}
