package functionalityClasses;

import java.util.ArrayList;

import courses.Course;
import util.DatabaseHandler;

public class CourseUpdate {
	
	public void addProfNames(ArrayList<String> profNames, String courseID) throws Exception {
		ArrayList<Course> courses = (ArrayList<Course>) DatabaseHandler.getCourseData(); 
		for (Course course : courses) {
			if(course.getCourseID().equals(courseID)) {
				for(String profName : profNames) {
					System.out.println("Im adding profname");
					course.addProfName(profName);
				}
			}
		}
		
	}
}
