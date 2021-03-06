package util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * <code>DataBaseManager</code> is the main IO class for UniApp. 
 * <p>
 * <code>DataBaseManager</code> permanently stores and reads serializable objects to/from
 * a .ser file. The current implementation handles all the exceptions within the 
 * methods and prints the entire stack trace onto the console. 
 * 
 * @author LFM
 */
public class DataBaseManager {

    /**
     * Unserializes a .ser file and returns <code>Object</code>.
     * 
     * @param fileName - name of .ser file to read from
     * @return <code>Object</code> from .ser file, or null if an exception was raised
     */

    public static Object retrieveData(String filename) throws Exception{
     File f = new File(filename);
     if(f.exists()) {
      FileInputStream fi = new FileInputStream(new File(filename));
      ObjectInputStream oi = new ObjectInputStream(fi);
      Object temp = oi.readObject();
      fi.close();
      oi.close();
      return temp;
     } else {
      updateData(new ArrayList<Object>(), filename);
      return new ArrayList<Object>();
     }
    }

    

    /**
     * Overwrites the current file with the new serialized Objects.
     * 
     * @param a - any object to be serialized
     * @param filename - name of .ser file to output to
     */
    public static void updateData(Object a, String filename) throws Exception{
     FileOutputStream fop=new FileOutputStream(filename);
     ObjectOutputStream oos=new ObjectOutputStream(fop);
     oos.writeObject(a);
     fop.close();
     oos.close();
    }
}