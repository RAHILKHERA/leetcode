package DesignPattern.StructuralPatterns.FlyWeight;

public class InvalidTreeTypeException extends Exception {
    public InvalidTreeTypeException(String message) {
        super(message);
    }

    public InvalidTreeTypeException(Throwable throwable) {
        super(throwable);
    }

    public InvalidTreeTypeException(String message, Throwable throwable) {
        super(message, throwable);
    }
}