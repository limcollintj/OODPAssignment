package Exceptions;

/**
 * <code>Exception</code> class to be thrown when a student is registered in 
 * course/lesson, and vice versa. This <code>Exception</code> class is specific
 * to the current application.
 * 
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class AlreadyRegisteredException extends Exception {
	/**
	 * Constructor of <code>AlreadyRegisteredException</code> class.
	 * @param type Object type which caused the <code>Exception</code>
	 */
	public AlreadyRegisteredException(String type){
		super("Already registered in " + type);
	}
}
