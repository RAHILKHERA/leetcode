package DesignPattern.StructuralPatterns.FacadePattern.HomeTheaterSystem;

import java.util.Arrays;

public class HomeTheaterFacade {
    
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private Amplifier amplifier;
    private Lights lights;
    private Screen screen;

    
    public HomeTheaterFacade () {
        dvdPlayer = new DVDPlayer();
        projector = new Projector();
        amplifier = new Amplifier();
        lights = new Lights(Arrays.asList("north-east light", "south-west light", "center light"));
        screen = new Screen();
    }

    public void watchMovie(String movie) {
        System.out.println("----- Preparing to Watch Movie -----");
        lights.on();
        screen.lowerScreen();
        projector.on();
        amplifier.on();
        dvdPlayer.on();
        lights.dim();
        amplifier.configureSound("Action Movie");
        amplifier.setVolume(70);
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("----- Movie Ended. Shutting Down System -----");
        dvdPlayer.stop();
        dvdPlayer.off();
        amplifier.off();
        projector.off();
        screen.raiseScreen();
        lights.off();
    }
}
