package DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.BeverageImpl;

import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.Beverage;

public class Espresso implements Beverage {

    public static final String description = "Espresso";
    public double cost;

    public Espresso() {
        cost = 50;
    }

    public Espresso(int cost) {
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
