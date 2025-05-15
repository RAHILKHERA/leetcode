package DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.AddOnImpl;

import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.Beverage;
import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.AddOn.BaseAddon;

public class WhippedCream extends BaseAddon {

    private static final String description = "WhippedCream";

    public WhippedCream(Beverage baseBeverage) {
        super(baseBeverage, description, 10);
    }

    public WhippedCream(Beverage baseBeverage, double cost) {
        super(baseBeverage, "WhippedCream", cost);
    }

    @Override
    public void setCost(double cost) {
        super.setCost(cost);
    }

}
