package DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.BeverageImpl;

import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.Beverage;

public class Latte implements Beverage {

    public static final String description = "Latte";
    public double cost;

    public Latte() {
        cost = 100;
    }

    public Latte(int cost) {
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
