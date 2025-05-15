package DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.AddOnImpl;

import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.Beverage;
import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.AddOn.BaseAddon;

public class Soy extends BaseAddon {

  private static final String description = "Soy";

    public Soy(Beverage baseBeverage) {
        super(baseBeverage, description, 20);
    }

    public Soy(Beverage baseBeverage, double cost) {
        super(baseBeverage, "Soy", cost);
    }

    @Override
    public void setCost(double cost) {
        super.setCost(cost);
    }
    
}
