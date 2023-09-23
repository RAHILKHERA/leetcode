package refelection;

import java.lang.reflect.Method;

public class RefelectionDemo {
    
    public static void main(String[] args) throws Exception{

        Class c = Class.forName("refelection.Test");    
        Test t = (Test) c.getDeclaredConstructor().newInstance();

        Method m = c.getDeclaredMethod("show", null);
        m.setAccessible(true);
        m.invoke(t, null);
    }
    
}
