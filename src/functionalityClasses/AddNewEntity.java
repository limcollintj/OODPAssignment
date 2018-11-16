package functionalityClasses;

/**
 * <code>AddNewEntity</code> class takes in an implementation of <code>CRUDByID</code>
 * and the ID of the desired entity <code>Object</code>. <code>AddNewEntity</code> can
 * be used to generate various <code>Object</code> which simplifies the creation process
 * and inverts the dependencies of the classes 
 * 
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class AddNewEntity {
	/**
	 * Add new entity <code>Object</code> according to the specified id parameter. 
	 * 
	 * @param CRUD Interface <code>CRUDByID</code> to specify which entity <code>Object</code>
	 * to create
	 * @param id ID of the entity <code>Object</code> created and added to container
	 * @throws Exception
	 */
	public void addEntity(CRUDByID CRUD, String id) throws Exception{
		CRUD.createByID(id);
	}
}
