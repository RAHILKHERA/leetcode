package DesignPattern.CreationalPatterns.BuilderPattern.Phone;

public enum PhoneOS {
    ANDROID("Android"), WINDOWS("Windows"), MACOS("Macos");

    String displayOS;

    PhoneOS(String displayOs) {
        this.displayOS = displayOs;
    }

    public String getDisplayOS() {
        return this.displayOS;
    }
}
