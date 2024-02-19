package DesignPattern.CreationalPatterns.BuilderPattern.Apple;

import DesignPattern.CreationalPatterns.BuilderPattern.Phone.Phone;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneOS;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneType;

public class ApplePhone implements Phone {

    private PhoneOS os;
    private int ramCapacity;
    private PhoneType type;
    private int resoultion;

    public ApplePhone(PhoneOS os, int ramCapacity, PhoneType type, int resoultion) {
        this.os = os;
        this.ramCapacity = ramCapacity;
        this.type = type;
        this.resoultion = resoultion;
    }

    public PhoneOS getOs() {
        return os;
    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    public PhoneType getType() {
        return type;
    }

    public int getResoultion() {
        return resoultion;
    }

    @Override
    public void display() {
        System.out.println("Apple :: Phone, OS :: " + os.getDisplayOS() + " Ram Capacity :: " + ramCapacity
                + " Resoultion :: " + resoultion + " Type :: " + type.getType());
    }

}
