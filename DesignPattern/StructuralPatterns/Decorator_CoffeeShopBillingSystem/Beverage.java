package DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem;

public interface Beverage {

    public String getDescription();
    
    public double getCost();
    public void setCost(double cost);
}
