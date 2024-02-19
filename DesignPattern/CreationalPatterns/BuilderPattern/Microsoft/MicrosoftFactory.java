package DesignPattern.CreationalPatterns.BuilderPattern.Microsoft;

import DesignPattern.CreationalPatterns.BuilderPattern.Factory;
import DesignPattern.CreationalPatterns.BuilderPattern.Laptop;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.Phone;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneOS;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneType;

public class MicrosoftFactory implements Factory {

    @Override
    public Phone createPhone() {
        MicrosoftPhoneBuilder phoneBuilder = new MicrosoftPhoneBuilder();
        phoneBuilder.setOs(PhoneOS.WINDOWS);
        phoneBuilder.setPhoneType(PhoneType.SMARTPHONE);
        phoneBuilder.setRam(512);
        phoneBuilder.setResolution(24);
        return phoneBuilder.getPhone();
    }

    @Override
    public Laptop createLaptop() {
        return new MicrosoftLaptop();
    }

}
