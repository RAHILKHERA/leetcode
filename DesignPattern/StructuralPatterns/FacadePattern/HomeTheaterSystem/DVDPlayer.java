package DesignPattern.StructuralPatterns.FacadePattern.HomeTheaterSystem;

public class DVDPlayer {
    
    private String movie;
    
    DVDPlayer() {}

    public void on() {
        System.out.println("Starting DVD Player...");
    }

    public void play (String movie) {
        this.movie = movie;
        System.out.println("Playing Movie  : " + movie);
    }

    public void stop() {
        System.out.println("Stopping movie : " + movie);
    }

    public void off() {
        System.out.println("Shutting Down DVD Player...");
    }
}
