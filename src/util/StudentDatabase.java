package util;

import java.util.List;

import students.Student;

public class StudentDatabase implements Database {
private final String STUDENT_FILENAME = "Students.txt";

	/**
	 * Gets data
	 * @return data
	 * @throws Exception
	 */
	@Override
	public List<Student> getData() throws Exception{
		Object temp = DataBaseManager.retrieveData(this.STUDENT_FILENAME);
        if(!(temp instanceof List)) {
        	throw new Exception("Object is not of List type.");
        } 
        List<Object> list = (List) temp;
        if(!list.isEmpty() && !(list.get(0) instanceof Student)) {
        	throw new Exception("Data is not of Student type");
        }
        return (List<Student>)temp;
	}

	/**
	 * Updates data
	 * @param object Object
	 * @throws Exception
	 */
	@Override
	public void updateData(Object object) throws Exception{
		if(!(object instanceof List)) {
			throw new Exception("Object is not of List type.");
		}
		List<Object> list= (List) object;
		if(!list.isEmpty() && !(list.get(0) instanceof Student)) {
			throw new Exception("Data stored in container must be of Student type");
		}
		DataBaseManager.updateData(object, this.STUDENT_FILENAME);
	}	
}
