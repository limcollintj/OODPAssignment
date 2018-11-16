package functionalityClasses;

/**
 * <code>Reset</code> class to reset the database of the entity classes
 * 
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public interface Reset {
	/**
	 * Clear all the entity <code>Object</code> within the database
	 * @throws Exception
	 */
	public void reset() throws Exception; 
	
	/**
	 * Print information of all the objects within the specified container
	 * @throws Exception
	 */
	public void printAll() throws Exception;
}
