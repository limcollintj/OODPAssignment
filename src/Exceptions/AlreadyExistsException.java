package Exceptions;

/**
 * <code>Exception</code> class to be thrown when an object already exists within its container class. 
 * This can be used when the objects must have unique fields. For this application, it is used to 
 * check if the entity classes hold unique IDs.
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class AlreadyExistsException extends Exception{
	/**
	 * Constructor of <code>AlreadyExistsException</code> class.
	 * @param type Object type which caused the error
	 */
	public AlreadyExistsException(String type) {
		super(type + "Already Exists");
	}
}
