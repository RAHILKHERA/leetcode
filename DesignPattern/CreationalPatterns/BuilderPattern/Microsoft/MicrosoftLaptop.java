package DesignPattern.CreationalPatterns.BuilderPattern.Microsoft;

import DesignPattern.CreationalPatterns.BuilderPattern.Laptop;

public class MicrosoftLaptop implements Laptop {

    @Override
    public void processingUnit() {
        System.out.println("Microsoft :: Processing Unit");
    }

}
