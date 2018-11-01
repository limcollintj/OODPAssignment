package util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <code>DataBaseManager</code> is the main IO class for UniApp. 
 * <p>
 * <code>DataBaseManager</code> permanently stores and reads {@link Serializable} objects to/from
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

    public static Object retrieveData(String fileName) throws Exception{

            FileInputStream fi = new FileInputStream(new File(fileName));
            ObjectInputStream oi = new ObjectInputStream(fi);
            Object temp = oi.readObject();
            fi.close();
            oi.close();
            return temp;

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
