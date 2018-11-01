package functionalityClasses;

import courses.Course;
import students.StudentManager;

public class FindCoursesByID implements FindByID{

	@Override
	public void findById(String id) {
		
		Course temp = getCourse(id); 
    	for (String studentID : temp.getregisteredStudentIDs()) {
    		StudentManager.getStudent(studentID).printInfo();
    	}
	}

}
