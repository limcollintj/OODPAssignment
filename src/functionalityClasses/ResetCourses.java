package functionalityClasses;

import java.util.ArrayList;

import courses.Course;
import util.DatabaseHandler;

public class ResetCourses implements Reset{

	@Override
	public void reset() throws Exception {
		
		DatabaseHandler.updateCourseData(new ArrayList<Course>());
		
	}

	@Override
	public void printAll() throws Exception {
		
		for (Course course : DatabaseHandler.getCourseData()) {
			course.printCourseInfo();
		}
		
	}

}
