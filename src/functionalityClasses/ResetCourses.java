package functionalityClasses;

import java.util.ArrayList;

import courses.Course;
import util.DatabaseHandler;

/**
 * Clears all <code>Course</code> objects within the course database.
 * 
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class ResetCourses implements Reset{

	/**
	 * Reset the database of <code>Course</code> objects
	 */
	@Override
	public void reset() throws Exception {
		DatabaseHandler.updateCourseData(new ArrayList<Course>());	//Overrides the current database with a new ArrayList
	}

	/**
	 * Iterates through all the <code>Course</code> objects and prints the specified information
	 */
	@Override
	public void printAll() throws Exception {
		for (Course course : DatabaseHandler.getCourseData()) {
			course.printCourseInfo();
		}
	}
}
