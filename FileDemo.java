import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileDemo {
    public static void main(String[] args) {

        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        

        FileInputStream fis = null;
        DataInputStream dis = null;
        try {
            f = new File("FileDemo.txt");
            fos = new FileOutputStream(f);
            dos = new DataOutputStream(fos);
            dos.writeUTF("Learning JAVA");


            fis = new FileInputStream(f);
            dis = new DataInputStream(fis);
            String fileContent = dis.readUTF();
            System.out.println(fileContent);
        } catch ( FileNotFoundException e) {
            System.out.println("File not found exeception occur`red");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO exception occurred.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unknow exception occurred.");
            e.printStackTrace();
        } finally {
          try {
            fis.close();
            dis.close();
            fos.close();
            dos.close();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }

    }
}
