package DesignPattern.CreationalPatterns.BuilderPattern.Phone;

public interface PhoneBuilder {

    void setPhoneType(PhoneType type);

    void setRam(int ramCapacity);

    void setOs(PhoneOS os);

    void setResolution(int resoultion);
}
