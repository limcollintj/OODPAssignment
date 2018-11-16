package functionalityClasses;

/**
 * Interface for printing by ID.
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public interface PrintByID {

	/**
	 * Print specific desired attributes of <code>Object</code> with a specified  ID.
	 * @param id ID of the desired <code>Object</code>
	 * @throws Exception
	 */
	public void printByID(String id) throws Exception;
}
