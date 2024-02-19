package DesignPattern.CreationalPatterns.BuilderPattern.Apple;

import DesignPattern.CreationalPatterns.BuilderPattern.Laptop;

public class AppleLaptop implements Laptop {

    @Override
    public void processingUnit() {
        System.out.println("Apple :: Processing Unit");
    }

}
