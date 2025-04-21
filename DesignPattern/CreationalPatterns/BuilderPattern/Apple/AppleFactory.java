package DesignPattern.CreationalPatterns.BuilderPattern.Apple;

import DesignPattern.CreationalPatterns.BuilderPattern.Factory;
import DesignPattern.CreationalPatterns.BuilderPattern.Laptop;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.Phone;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneOS;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneType;

public class AppleFactory implements Factory {

    @Override
    public Phone createPhone() {
        return new ApplePhoneBuilder()
                .setOs(PhoneOS.MACOS)
                .setPhoneType(PhoneType.SMARTPHONE)
                .setRam(256)
                .setResolution(12)
                .getPhone();
    }

    @Override
    public Laptop createLaptop() {
        return new AppleLaptop();
    }

}
