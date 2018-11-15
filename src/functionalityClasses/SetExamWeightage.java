package functionalityClasses;

import java.util.ArrayList;

import courses.Course;
import functionalityClasses.SetWeightage;
import util.DatabaseHandler;

public class SetExamWeightage implements SetWeightage{

	@Override
	public void setWeightage(String courseID, int weightage) throws Exception {
		ArrayList<Course> courses = (ArrayList<Course>) DatabaseHandler.getCourseData();

		for(Course course : courses) {
			if(course.getCourseID().equals(courseID)) {
				course.setEXWeightage(100 - weightage);
			}
		}
		DatabaseHandler.updateCourseData(courses);
	}	
}
