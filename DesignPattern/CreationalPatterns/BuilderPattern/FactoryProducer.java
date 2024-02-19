package DesignPattern.CreationalPatterns.BuilderPattern;

import DesignPattern.CreationalPatterns.BuilderPattern.Apple.AppleFactory;
import DesignPattern.CreationalPatterns.BuilderPattern.Microsoft.MicrosoftFactory;

public class FactoryProducer {

    public Factory getFactory(FactoryType factory) {

        switch (factory) {
            case MICROSOFT:
                return new MicrosoftFactory();

            case APPLE:
                return new AppleFactory();
        }

        throw new RuntimeException("Invalid factory type : " + factory);

    }
}
