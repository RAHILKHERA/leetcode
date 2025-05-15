package DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.BeverageImpl;

import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.Beverage;

public class Cappuccino implements Beverage {

    public static final String description = "Cappuccino";
    public double cost;

    public Cappuccino() {
        cost = 75;
    }

    public Cappuccino(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
