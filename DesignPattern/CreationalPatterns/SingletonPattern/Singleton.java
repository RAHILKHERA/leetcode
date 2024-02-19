package DesignPattern.CreationalPatterns.SingletonPattern;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    private static volatile Singleton INSTANCE;

    private Singleton() {
        if (INSTANCE != null) {
            throw new RuntimeException("Use getInstance() method to get the instance.");
        }
    }

    public static Singleton getInstance() {

        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }

        }

        return INSTANCE;

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of Singleton is not allowed");
    }

    protected Object readResolve() {
        return getInstance();
    }

    public Object readResolve(Object obj) throws ObjectStreamException {
        return getInstance();
    }
}
