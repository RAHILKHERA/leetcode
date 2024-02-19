package DesignPattern.CreationalPatterns.BuilderPattern.Apple;

import DesignPattern.CreationalPatterns.BuilderPattern.Factory;
import DesignPattern.CreationalPatterns.BuilderPattern.Laptop;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.Phone;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneOS;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneType;

public class AppleFactory implements Factory {

    @Override
    public Phone createPhone() {
        ApplePhoneBuilder phoneBuilder = new ApplePhoneBuilder();
        phoneBuilder.setOs(PhoneOS.MACOS);
        phoneBuilder.setPhoneType(PhoneType.SMARTPHONE);
        phoneBuilder.setRam(256);
        phoneBuilder.setResolution(12);
        return phoneBuilder.getPhone();
    }

    @Override
    public Laptop createLaptop() {
        return new AppleLaptop();
    }

}
