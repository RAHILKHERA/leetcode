package DesignPattern.CreationalPatterns.BuilderPattern.Microsoft;

import DesignPattern.CreationalPatterns.BuilderPattern.Phone.Phone;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneBuilder;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneOS;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneType;

public class MicrosoftPhoneBuilder implements PhoneBuilder {
    private PhoneOS os;
    private int ramCapacity;
    private PhoneType type;
    private int resoultion;

    @Override
    public void setPhoneType(PhoneType type) {
        this.type = type;
    }

    @Override
    public void setRam(int ramCapacity) {
        this.ramCapacity = ramCapacity;
    }

    @Override
    public void setOs(PhoneOS os) {
        this.os = os;
    }

    @Override
    public void setResolution(int resoultion) {
        this.resoultion = resoultion;
    }

    public Phone getPhone() {
        return new MicrosoftPhone(os, ramCapacity, type, resoultion);
    }
}
