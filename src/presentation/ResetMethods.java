package presentation;

import courses.CourseManager;
import students.StudentManager;

public class ResetMethods {
	
	public static void resetCourses() {
		CourseManager cm = new CourseManager(); 
		
		cm.resetCourses();
	}
	
	public static void resetStudents() {
		StudentManager sm = new StudentManager(); 
		
		sm.resetStudents();
	}
	
}
