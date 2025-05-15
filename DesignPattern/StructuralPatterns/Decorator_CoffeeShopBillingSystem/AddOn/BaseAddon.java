package DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.AddOn;

import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.Beverage;

public abstract class BaseAddon implements Beverage {

    private Beverage baseBeverage;
    private String description;
    private double cost;
  
    public BaseAddon(Beverage baseBeverage, String addOnDescription, double cost) {
        this.baseBeverage = baseBeverage;
        this.description = addOnDescription;
        this.cost = cost;
    }

    public Beverage getBaseBeverage() {
        return baseBeverage;
    }

    @Override
    public String getDescription() {
       return getBaseBeverage().getDescription() + ", " + description;
    }

    @Override
    public double getCost() {
        return getBaseBeverage().getCost() + cost;
    }

    @Override
    public void setCost(double cost) {
       this.cost = cost;
    }

}
