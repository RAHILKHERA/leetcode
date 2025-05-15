package DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.AddOnImpl;

import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.Beverage;
import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.AddOn.BaseAddon;

public class Milk extends BaseAddon {

    private static final String description = "Milk";

    public Milk(Beverage baseBeverage) {
        super(baseBeverage, description, 10);
    }

    public Milk(Beverage baseBeverage, double cost) {
        super(baseBeverage, "Milk", cost);
    }

    @Override
    public void setCost(double cost) {
        super.setCost(cost);
    }

}
