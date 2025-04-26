package DesignPattern.StructuralPatterns.BridgePattern.Vehicles;

import DesignPattern.StructuralPatterns.BridgePattern.Directions;

public interface Vehicle {

    public void startEngine();
    public void stopEngine();
    public void move(Directions dir);
    public void accelerate();
    public void brake();
} 