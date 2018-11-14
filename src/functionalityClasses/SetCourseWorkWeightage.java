package functionalityClasses;

import java.util.ArrayList;

import courses.Course;
import util.DatabaseHandler;

public class SetCourseWorkWeightage implements SetWeightage{

	@Override
	public void setWeightage(String courseID, int weightage) throws Exception {
		ArrayList<Course> courses = (ArrayList<Course>) DatabaseHandler.getCourseData();
		
		for(Course course : courses) {
			if(course.getCourseID().equals(courseID)) {
				course.setCWWeightage(weightage);
				course.setEXWeightage(100 - weightage);
			}
		}
		DatabaseHandler.updateCourseData(courses);
	}


}
