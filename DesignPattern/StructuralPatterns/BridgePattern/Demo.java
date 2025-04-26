package DesignPattern.StructuralPatterns.BridgePattern;

import DesignPattern.StructuralPatterns.BridgePattern.ControlImpl.AdvancedControl;
import DesignPattern.StructuralPatterns.BridgePattern.ControlImpl.AutoPilotControl;
import DesignPattern.StructuralPatterns.BridgePattern.ControlImpl.ManualControl;
import DesignPattern.StructuralPatterns.BridgePattern.Controls.VehicleControl;
import DesignPattern.StructuralPatterns.BridgePattern.VehicleImpl.Car;
import DesignPattern.StructuralPatterns.BridgePattern.VehicleImpl.Truck;
import DesignPattern.StructuralPatterns.BridgePattern.Vehicles.Vehicle;

public class Demo {
    public static void main(String[] args) {
        System.out.println("---------Car with Autopilot Control----------");
        Vehicle autoCar = new Car();
        VehicleControl autoCarControl = new AutoPilotControl(autoCar);
        autoCarControl.start();
        autoCarControl.move(Directions.FORWARD);
        autoCarControl.increaseSpeed();
        autoCarControl.decreaseSpeed();
        autoCarControl.stop();

        System.out.println("---------Car with Manual Control----------");
        Vehicle manualCar = new Car();
        VehicleControl manualCarControl = new ManualControl(manualCar);
        manualCarControl.start();
        manualCarControl.move(Directions.FORWARD);
        manualCarControl.increaseSpeed();
        manualCarControl.decreaseSpeed();
        manualCarControl.stop();

        System.out.println("---------Truck with Autopilot Control----------");
        Vehicle autoTruck = new Truck();
        VehicleControl autoTruckControl = new AutoPilotControl(autoTruck);
        autoTruckControl.start();
        autoTruckControl.move(Directions.FORWARD);
        autoTruckControl.increaseSpeed();
        autoTruckControl.decreaseSpeed();
        autoTruckControl.stop();

        System.out.println("---------Truck with Manual Control----------");
        Vehicle manualTruck = new Truck();
        VehicleControl manualTruckControl = new ManualControl(manualTruck);
        manualTruckControl.start();
        manualTruckControl.move(Directions.FORWARD);
        manualTruckControl.increaseSpeed();
        manualTruckControl.decreaseSpeed();
        manualTruckControl.stop();

        System.out.println("---------Car with Advanced Control----------");
        Vehicle advancedCar = new Car();
        AdvancedControl advancedControl = new AdvancedControl(advancedCar);
        advancedControl.start();
        advancedControl.enableCruiseControl();
        advancedControl.move(Directions.FORWARD);
        advancedControl.enableSelfParking();
        advancedControl.stop();

    }
}
