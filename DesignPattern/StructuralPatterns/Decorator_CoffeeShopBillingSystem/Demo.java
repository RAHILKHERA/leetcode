package DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem;

import java.util.logging.Logger;

import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.AddOnImpl.Milk;
import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.AddOnImpl.Mocha;
import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.BeverageImpl.Espresso;
import DesignPattern.StructuralPatterns.Decorator_CoffeeShopBillingSystem.BeverageImpl.Latte;

public class Demo {
    private static Logger LOGGER = Logger.getLogger(Demo.class.getSimpleName());
    public static void main(String[] args) {
        Beverage latte = new Latte(100);
        Beverage milkLatte = new Milk(latte, 20);
        Beverage mochaMilkLatte = new Mocha(milkLatte, 40);
        LOGGER.info(mochaMilkLatte.getDescription()  + " coffee will cost " + mochaMilkLatte.getCost());

        Beverage coffee2 = new Milk(new Milk(new Mocha(new Espresso())));
        LOGGER.info(coffee2.getDescription()  + " coffee will cost " + coffee2.getCost());
    }
}
