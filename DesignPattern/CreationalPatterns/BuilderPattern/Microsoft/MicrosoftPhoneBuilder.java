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
    public MicrosoftPhoneBuilder setPhoneType(PhoneType type) {
        this.type = type;
        return this;
    }

    @Override
    public MicrosoftPhoneBuilder setRam(int ramCapacity) {
        this.ramCapacity = ramCapacity;
        return this;
    }

    @Override
    public MicrosoftPhoneBuilder setOs(PhoneOS os) {
        this.os = os;
        return this;
    }

    @Override
    public MicrosoftPhoneBuilder setResolution(int resoultion) {
        this.resoultion = resoultion;
        return this;
    }

    public Phone getPhone() {
        return new MicrosoftPhone(this);
    }

    @Override
    public PhoneType getPhoneType() {
        return type;
    }

    @Override
    public int getRamCapacity() {
        return ramCapacity;
    }

    @Override
    public PhoneOS getOs() {
        return os;
    }

    @Override
    public int getResolution() {
        return resoultion;
    }
}
