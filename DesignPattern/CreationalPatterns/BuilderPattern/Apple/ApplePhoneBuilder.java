package DesignPattern.CreationalPatterns.BuilderPattern.Apple;

import DesignPattern.CreationalPatterns.BuilderPattern.Phone.Phone;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneBuilder;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneOS;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneType;

public class ApplePhoneBuilder implements PhoneBuilder {

    private PhoneOS os;
    private int ramCapacity;
    private PhoneType type;
    private int resoultion;

    @Override
    public ApplePhoneBuilder setPhoneType(PhoneType type) {
        this.type = type;
        return this;
    }

    @Override
    public ApplePhoneBuilder setRam(int ramCapacity) {
        this.ramCapacity = ramCapacity;
        return this;
    }

    @Override
    public ApplePhoneBuilder setOs(PhoneOS os) {
        this.os = os;
        return this;
    }

    @Override
    public ApplePhoneBuilder setResolution(int resoultion) {
        this.resoultion = resoultion;
        return this;
    }

    public Phone getPhone() {
        return new ApplePhone(this);
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
