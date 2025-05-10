package DesignPattern.BehavioralPatterns.MediatorAirTrafficControl;

public enum RunwayStatus {
    AVAILABLE("available"),
    NOT_AVAILABLE("not available");

    private String status; 

    RunwayStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static RunwayStatus geStatus(String status) {
        if (status.equals("available")) {
            return AVAILABLE;
        }
        return NOT_AVAILABLE;
    }
}
