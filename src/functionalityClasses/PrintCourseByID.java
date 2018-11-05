package functionalityClasses;

import courses.Course;
import students.Student;
import students.StudentManager;
import util.DatabaseHandler;


/**
 Class for printing list of courses by ID.
 @author LFM
 @version 1.0
 @since 2018-11-05
 */

public class PrintCourseByID implements PrintByID{

	/**
	 * Print courses by ID.
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void printByID(String id) throws Exception {
		
		Course temp = new CourseCRUDByID().readByID(id);
		CRUDByID crudID = new StudentCRUDByID();
		
    	for (String studentID : temp.getregisteredStudentIDs()) {
    		Student stud = (Student) crudID.readByID(studentID);
    		stud.printInfo();
		
	}

	

}

}