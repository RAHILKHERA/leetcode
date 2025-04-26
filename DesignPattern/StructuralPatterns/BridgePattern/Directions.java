package DesignPattern.StructuralPatterns.BridgePattern;



public enum Directions {
    
    FORWARD("forward"),
    REVERSE( "reverse"),
    LEFT("left"),
    RIGHT("right");

    private String direction;

    Directions(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
