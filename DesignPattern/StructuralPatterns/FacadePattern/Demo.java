package DesignPattern.StructuralPatterns.FacadePattern;

import DesignPattern.StructuralPatterns.FacadePattern.HomeTheaterSystem.HomeTheaterFacade;

public class Demo {
    
    public static void main(String[] args) {
        HomeTheaterFacade homeTheaterSystem = new HomeTheaterFacade();
        homeTheaterSystem.watchMovie("Transformers : Revenge of the Fallen.");
        homeTheaterSystem.endMovie();
    }
}
