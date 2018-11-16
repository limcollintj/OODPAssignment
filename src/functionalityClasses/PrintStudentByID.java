package functionalityClasses;

import Exceptions.EntityNotFoundException;
import students.Student;

/**
 * Class for printing list of courses by student with the specified ID.
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class PrintStudentByID implements PrintByID{

	/**
	 * Print list of course information whereby <code>Student</code> with the specified ID has registered in
	 * @param id ID of desired entity object
	 * @throws EntityNotFoundException when <code>Student</code> with the specified ID cannot be found
	 * @throws Exception
	 */
	@Override
	public void printByID(String id) throws EntityNotFoundException, Exception {
		Student student;    	
		student = new StudentCRUDByID().readByID(id);	//Returns null if student not found
		if(student != null) {
			for(String courseID : student.getCourseIDs()) {	//Iterate through the student's courseID ArrayList
				new CourseCRUDByID().readByID(courseID).printCourseInfo(); 
				System.out.println(id + " has registered in ");
			}
		} else {
			throw new EntityNotFoundException();
		}
	}
}
