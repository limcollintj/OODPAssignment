package functionalityClasses;

import courses.Course;
import students.StudentManager;
import util.DatabaseHandler;

public class PrintCourseByID implements PrintByID{


	@Override
	public void printByID(String id) throws Exception {
		
		Course temp = new CourseCRUDByID().readByID(id);
    	for (String studentID : temp.getregisteredStudentIDs()) {
    		StudentManager.getStudent(studentID).printInfo();
    	}
		
	}

	

}
