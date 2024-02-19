package DesignPattern.CreationalPatterns.AbstractMethodPattern;

public class AppleFactory implements Factory {

    @Override
    public Phone createPhone() {
        return new ApplePhone();
    }

    @Override
    public Laptop createLaptop() {
        return new AppleLaptop();
    }

}
