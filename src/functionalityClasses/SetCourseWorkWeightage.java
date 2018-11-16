package functionalityClasses;

import java.util.ArrayList;

import courses.Course;
import util.DatabaseHandler;

/**
 * Concrete class to edit coursework weightage of a specific <code>Course</code>
 * 
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class SetCourseWorkWeightage implements SetWeightage{

	/**
	 * Updates the coursework weightage of the the <code>Course</code> with the specific ID
	 * @param courseID ID of desired <code>Course</code>
	 * @param weightage integer value between 0 and 100
	 */
	@Override
	public void setWeightage(String courseID, int weightage) throws Exception {
		ArrayList<Course> courses = (ArrayList<Course>) DatabaseHandler.getCourseData();
		for(Course course : courses) {	//Iterates through the course container to find the course
			if(course.getCourseID().equals(courseID)) {
				course.setCWWeightage(weightage);	//Updates coursework weightage
				course.setEXWeightage(100 - weightage);	//Instantly updates exam weightage to ensure sum of both 
														//weightages add up to 100%
			}
		}
		DatabaseHandler.updateCourseData(courses);
	}
}
