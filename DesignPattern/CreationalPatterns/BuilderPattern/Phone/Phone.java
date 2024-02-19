package DesignPattern.CreationalPatterns.BuilderPattern.Phone;

public interface Phone {

    void display();

    PhoneOS getOs();

    public int getRamCapacity();

    public PhoneType getType();

    public int getResoultion();
}
