import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialDemo {
 
    public static void main(String[] args) {
        
        File f = null;
        FileOutputStream fos = null;
        FileInputStream fis = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {

            Save obj = new Save();
            obj.i=123456;
            f = new File("Obj.json");
            
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);

            
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Save obj1 =   (Save)ois.readObject();
            System.out.println(obj1.i);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                fis.close();
                oos.close();
                ois.close();    
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
             

    
    }
}

class Save implements Serializable{

    private static final long serialversionUID =
                                 129348938L;
    int i;

    public static void main(String[] args) {
        System.out.println(serialversionUID);
    }

}
