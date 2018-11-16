package functionalityClasses;


/**
 * Interface for creating, reading, updating and deleting <code>Object</code> by ID.
 * This interface is mainly used to simplify the operations of CRUD on a container class
 * which also allows for dependency injection
 *
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public interface CRUDByID {
	/**
	 * Create <code>Object</code> by ID.
	 * @param id
	 * @throws Exception
	 */
	void createByID(String id) throws Exception;

	/**
	 * Read <code>Object</code> by ID.
	 * @param id
	 * @return Object with the corresponding id
	 * @throws Exception
	 */
	Object readByID(String id) throws Exception;

	/**
	 * Update <code>Object</code> by ID.
	 * @param id
	 * @param o Object to replace
	 * @throws Exception
	 */
	void updateByID(String id, Object o) throws Exception;

	/**
	 * Delete <code>Object</code> by ID.
	 * @param id ID of desired object to be removed
	 * @throws Exception
	 */
	void deleteByID(String id) throws Exception;

}

