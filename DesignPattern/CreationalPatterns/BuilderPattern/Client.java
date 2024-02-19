package DesignPattern.CreationalPatterns.BuilderPattern;

import DesignPattern.CreationalPatterns.BuilderPattern.Phone.Phone;

public class Client {
    public static void main(String[] args) {

        FactoryProducer producer = new FactoryProducer();

        Factory factory = producer.getFactory(FactoryType.MICROSOFT);
        Phone phone = factory.createPhone();
        Laptop laptop = factory.createLaptop();
        phone.display();
        laptop.processingUnit();

        factory = producer.getFactory(FactoryType.APPLE);
        phone = factory.createPhone();
        laptop = factory.createLaptop();
        phone.display();
        laptop.processingUnit();
    }
}
