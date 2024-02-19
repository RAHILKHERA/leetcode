package DesignPattern.CreationalPatterns.AbstractMethodPattern;

public class MicrosoftFactory implements Factory {

    @Override
    public Phone createPhone() {
        return new MicrosoftPhone();
    }

    @Override
    public Laptop createLaptop() {
        return new MicrosoftLaptop();
    }

}
