package DesignPattern.StructuralPatterns.FacadePattern.HomeTheaterSystem;

public class Projector {
  

    public void on() {
     
        System.out.println("Starting up the Projector...");
    }

    public void setMode(boolean wideScreen) {
        System.out.println(wideScreen ? "WideScreen Mode" : "Normal Mode");
    }

    public void off() {
        System.out.println("Shutting down the projector...");
    }
}
