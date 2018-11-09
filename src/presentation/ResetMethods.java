package presentation;

import courses.CourseManager;
import students.StudentManager;

public class ResetMethods {

	/**
	 * Resets all courses
	 * @throws Exception
	 */
	public static void resetCourses() throws Exception {
		CourseManager cm = new CourseManager(); 
		
		cm.resetCourses();
	}

	/**
	 * Resets all students
	 * @throws Exception
	 */
	
	public static void resetStudents() throws Exception {
		StudentManager sm = new StudentManager(); 
		
		sm.resetStudents();
	}
	
}
