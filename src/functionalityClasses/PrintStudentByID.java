package functionalityClasses;

import courses.Course;
import courses.CourseManager;
import students.Student;
import util.DatabaseHandler;

/**
 Class for printing list fo students by ID.
 @author LFM
 @version 1.0
 @since 2018-11-05
 */

public class PrintStudentByID implements PrintByID{


	/**
	 * Print list of students by ID.
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void printByID(String id) throws Exception {
		Student student;    	
		
			student = new StudentCRUDByID().readByID(id);
			for(String courseID : student.getCourseIDs()) {
	    		new CourseCRUDByID().readByID(courseID).printCourseInfo();
	        	System.out.println(id + " has registered in ");
			}
			
	}

}
