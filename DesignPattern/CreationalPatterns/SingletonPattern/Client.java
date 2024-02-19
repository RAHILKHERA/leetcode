package DesignPattern.CreationalPatterns.SingletonPattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Client {
    public static void main(String[] args) {
        try {
            Singleton instance1 = Singleton.getInstance();
            ObjectOutput out = new ObjectOutputStream(
                    new FileOutputStream("file.text"));

            out.writeObject(instance1);
            out.close();

            // deserialize from file to object
            ObjectInput in = new ObjectInputStream(
                    new FileInputStream("file.text"));
            Singleton instance2 = (Singleton) in.readObject();
            in.close();

            System.out.println("instance1 hashCode:- "
                    + instance1.hashCode());
            System.out.println("instance2 hashCode:- "
                    + instance2.hashCode());

            // reflection

            Singleton instance4 = null;
            try {
                Constructor[] constructors = Singleton.class.getDeclaredConstructors();
                for (Constructor constructor : constructors) {
                    // Below code will destroy the singleton
                    // pattern
                    constructor.setAccessible(true);
                    instance4 = (Singleton) constructor.newInstance();
                    break;
                }
            }

            catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("instance1.hashCode():- "
                    + instance1.hashCode());
            System.out.println("instance4.hashCode():- "
                    + instance4.hashCode());

            // clone
            Singleton instance3 = (Singleton) instance1.clone();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
