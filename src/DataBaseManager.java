import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class DataBaseManager {

    // Returns an Object by calling filename
    public static Object retrieveData(String fileName) {
        try {
            FileInputStream fi = new FileInputStream(new File(fileName));
            ObjectInputStream oi = new ObjectInputStream(fi);
            Object temp = oi.readObject();
            fi.close();
            oi.close();
            return temp;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    // Writes Object Given filename
    public static void updateData(Object a, String filename) {
        try {
            File f = new File(filename);
            FileOutputStream fop=new FileOutputStream(filename);
            ObjectOutputStream oos=new ObjectOutputStream(fop);

            oos.writeObject(a);

            fop.close();
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
