package DesignPattern.StructuralPatterns.BridgePattern.VehicleImpl;

import DesignPattern.StructuralPatterns.BridgePattern.Directions;
import DesignPattern.StructuralPatterns.BridgePattern.Vehicles.Vehicle;

public class Car implements Vehicle {

    @Override
    public void startEngine() {
       System.out.println("Starting Car Engine.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping Car Engine.");
    }

    @Override
    public void move(Directions dir) {
       System.out.println("Moving Car in " + dir.getDirection() + " direction.");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating Car Speed.");
    }

    @Override
    public void brake() {
       System.out.println("Reducing Car Speed");
    }
    
}
