package presentation;

import courses.CourseManager;
import students.StudentManager;

public class ResetMethods {

	/**
	 * Resets all courses
	 * @throws Exception
	 */
	public static void resetCourses(){
		CourseManager cm = new CourseManager(); 
		try {
			cm.resetCourses();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Resets all students
	 * @throws Exception
	 */
	public static void resetStudents(){

		StudentManager sm = new StudentManager(); 
		try {
			sm.resetStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
