package presentation;

import courses.CourseManager;
import students.StudentManager;

public class ResetMethods {
	
	public static void resetCourses() throws Exception {
		CourseManager cm = new CourseManager(); 
		
		cm.resetCourses();
	}
	
	public static void resetStudents() throws Exception {
		StudentManager sm = new StudentManager(); 
		
		sm.resetStudents();
	}
	
}
