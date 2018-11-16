package Exceptions;

/**
 * <code>Exception</code> class to be thrown when an entity object cannot be found
 * in its container. 
 * 
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class EntityNotFoundException extends Exception{
	/**
	 * Constructor of <code>EntityNotFoundException</code> class.
	 */
	public EntityNotFoundException(){
		super("Entity Not Found"); 
	}
}
