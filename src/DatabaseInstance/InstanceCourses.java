package DatabaseInstance;

import java.util.ArrayList;

import courses.Course;
import util.DatabaseHandler;

public class InstanceCourses {
	
	protected ArrayList<Course> courses;
	
	protected InstanceCourses() throws Exception {
		this.courses = (ArrayList<Course>) DatabaseHandler.getCourseData();
	}

}
