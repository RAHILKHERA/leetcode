import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropetiesFileDemo {
    public static void main(String[] args) {
        

        File f = null;
        OutputStream os  = null;
        InputStream is = null;
        try {
            f = new File("Demo.properties");
            Properties p = new Properties();
            os = new FileOutputStream(f);

            p.setProperty("name", "Rahil");
            p.setProperty("age", "34");
            p.setProperty("profession", "Software Developer");

            p.store(os,null);

            is = new FileInputStream(f);
            p.load(is);
            p.list(System.out);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
