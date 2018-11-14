package functionalityClasses;


/**
 Interface for creating, reading, updating and deleting by ID.
 @author LFM
 @version 1.0
 @since 2018-11-05
 */
public interface CRUDByID {
	/**
	 * Create ____ by ID.
	 * @param id
	 * @throws Exception
	 */
	void createByID(String id) throws Exception;

	/**
	 * Read ____ by ID.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Object readByID(String id) throws Exception;

	/**
	 * Update ____ by ID.
	 * @param id
	 * @throws Exception
	 */
	void updateByID(String id) throws Exception;

	/**
	 * Delete ____ by ID.
	 * @param id
	 * @throws Exception
	 */
	void deleteByID(String id) throws Exception;

}

