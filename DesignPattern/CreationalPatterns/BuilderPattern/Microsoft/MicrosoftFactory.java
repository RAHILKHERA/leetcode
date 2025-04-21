package DesignPattern.CreationalPatterns.BuilderPattern.Microsoft;

import DesignPattern.CreationalPatterns.BuilderPattern.Factory;
import DesignPattern.CreationalPatterns.BuilderPattern.Laptop;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.Phone;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneOS;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneType;

public class MicrosoftFactory implements Factory {

    @Override
    public Phone createPhone() {
        return new MicrosoftPhoneBuilder()
                .setOs(PhoneOS.WINDOWS)
                .setPhoneType(PhoneType.SMARTPHONE)
                .setRam(512)
                .setResolution(24)
                .getPhone();
    }

    @Override
    public Laptop createLaptop() {
        return new MicrosoftLaptop();
    }

}
