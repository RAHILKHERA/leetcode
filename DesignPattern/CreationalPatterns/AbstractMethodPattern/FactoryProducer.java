package DesignPattern.CreationalPatterns.AbstractMethodPattern;

public class FactoryProducer {

    public Factory getFactory(FactoryType factory) {

        switch (factory) {
            case MICROSOFT:
                return new MicrosoftFactory();

            case APPLE:
                return new AppleFactory();
        }

        return null;

    }
}
