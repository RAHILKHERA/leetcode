package DesignPattern.StructuralPatterns.FacadePattern.HomeTheaterSystem;

public class Amplifier {

    Amplifier() {}
    
    public void on() {
        System.out.println("Starting Amplifier...");
    } 

    public void off() {
        System.out.println("Shutting Down Amplifier.");
    }

    public void setVolume(int volume) {
        System.out.println("Volume set to : " + volume);
    }

    public void configureSound(String configuration) {
        System.out.println("Configuring volume for " + configuration);
    }
}
