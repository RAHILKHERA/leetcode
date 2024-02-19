package DesignPattern.CreationalPatterns.BuilderPattern;

public enum FactoryType {
    /**
     *
     */
    MICROSOFT("Microsoft"),
    APPLE("Apple");

    String displayString;

    FactoryType(String type) {
        this.displayString = type;
    }
}
