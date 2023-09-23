package DesignPattern.CreationalPatterns.FactoryMethodPattern;

abstract class Plan {
    protected double rate;
    abstract void setRate();
    
    public double calculateBill(int units) {
        return units * rate;
    };
}
