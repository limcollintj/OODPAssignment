package functionalityClasses;

import courses.Course;
import courses.CourseManager;
import students.Student;
import util.DatabaseHandler;

public class PrintStudentByID implements PrintByID{


	
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
