package DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.AddOnImpl;

import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.Beverage;
import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.AddOn.BaseAddon;

public class Mocha extends BaseAddon {

    private static final String description = "Mocha";

    public Mocha(Beverage baseBeverage) {
        super(baseBeverage, description, 10);
    }

    public Mocha(Beverage baseBeverage, double cost) {
        super(baseBeverage, "Mocha", cost);
    }

    @Override
    public void setCost(double cost) {
        super.setCost(cost);
    }

}

