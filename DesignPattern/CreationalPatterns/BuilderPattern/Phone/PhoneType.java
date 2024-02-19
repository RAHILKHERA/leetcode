package DesignPattern.CreationalPatterns.BuilderPattern.Phone;

public enum PhoneType {
    SMARTPHONE("Smart Phone"), CLASSIC("Classic");

    private String displayType;

    PhoneType(String displayString) {
        this.displayType = displayString;
    }

    public String getType() {
        return displayType;
    }

}
