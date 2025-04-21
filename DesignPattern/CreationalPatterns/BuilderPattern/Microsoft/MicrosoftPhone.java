package DesignPattern.CreationalPatterns.BuilderPattern.Microsoft;

import DesignPattern.CreationalPatterns.BuilderPattern.Phone.Phone;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneBuilder;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneOS;
import DesignPattern.CreationalPatterns.BuilderPattern.Phone.PhoneType;

public class MicrosoftPhone implements Phone {

    private PhoneOS os;
    private int ramCapacity;
    private PhoneType type;
    private int resoultion;

    public MicrosoftPhone(PhoneBuilder phoneBuilder) {
        os = phoneBuilder.getOs();
        ramCapacity = phoneBuilder.getRamCapacity();
        type = phoneBuilder.getPhoneType();
        resoultion = phoneBuilder.getResolution();
    }

    @Override
    public void display() {
        System.out.println("Microsoft :: Phone, OS :: " + os.getDisplayOS() + " Ram Capacity :: " + ramCapacity
                + " Resoultion :: " + resoultion + " Type :: " + type.getType());
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

}
