package DesignPattern.CreationalPatterns.BuilderPattern.Phone;

public interface PhoneBuilder {

    PhoneBuilder setPhoneType(PhoneType type);

    PhoneBuilder setRam(int ramCapacity);

    PhoneBuilder setOs(PhoneOS os);

    PhoneBuilder setResolution(int resoultion);

    PhoneType getPhoneType();

    int getRamCapacity();

    PhoneOS getOs();

    int getResolution();
}
