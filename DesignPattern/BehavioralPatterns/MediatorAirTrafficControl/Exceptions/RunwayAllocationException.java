package DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.Exceptions;

public class RunwayAllocationException extends Exception {
    public RunwayAllocationException(String message) {
        super(message);
    }

    public RunwayAllocationException(Throwable clause) {
        super(clause);
    }

    public RunwayAllocationException(String message, Throwable clause) {
        super(message, clause);
    }
}
