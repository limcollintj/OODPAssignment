package util;

import java.util.List;

import courses.Course;

public class CourseDatabase implements Database{
private final String COURSE_FILENAME = "Courses.txt";

	/**
	 * Retrieve data
 	 * @return data
	 * @throws Exception
	 */

	@Override
	public List<Course> getData() throws Exception{
		Object temp = DataBaseManager.retrieveData(this.COURSE_FILENAME);
        if(!(temp instanceof List)) {
        	throw new Exception("Object is not of List type.");
        } 
        List<Object> list = (List) temp;
        if(!list.isEmpty() && !(list.get(0) instanceof Course)) {
        	throw new Exception("Data is not of Course type");
        }
        return (List<Course>) temp;
	}

	/**
	 * Update object information
	 * @param object Object
	 * @throws Exception
	 */
	
	@Override
	public void updateData(Object object) throws Exception{
		if(!(object instanceof List)) {
			throw new Exception("Object is not of List type.");
		}
		List<Object> list= (List) object;
		if(!list.isEmpty() && !(list.get(0) instanceof Course)) {
			throw new Exception("Data stored in container must be of Course type");
		}
		DataBaseManager.updateData(object, this.COURSE_FILENAME);
	}	
}
