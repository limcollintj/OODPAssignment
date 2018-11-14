package functionalityClasses;

import java.util.ArrayList;

import courses.Course;
import util.DatabaseHandler;

public class SetClassPartWeightage implements SetWeightage{

	@Override
	public void setWeightage(String courseID, int weightage) throws Exception {
		ArrayList<Course> courses = (ArrayList<Course>) DatabaseHandler.getCourseData();
		
		for(Course course : courses) {
			if(course.getCourseID().equals(courseID)) {
				course.setCPWeightage(weightage);
				course.setASWeightage(100 - weightage);
			}
		}
		
		DatabaseHandler.updateCourseData(courses);
		
	}

}
