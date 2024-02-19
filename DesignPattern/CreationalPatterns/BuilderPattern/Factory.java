package DesignPattern.CreationalPatterns.BuilderPattern;

import DesignPattern.CreationalPatterns.BuilderPattern.Phone.Phone;

public interface Factory {
    public Phone createPhone();

    public Laptop createLaptop();
}
