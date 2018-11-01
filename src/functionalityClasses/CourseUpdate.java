package functionalityClasses;

import java.util.ArrayList;

import courses.Course;
import students.Student;
import util.DatabaseHandler;

public class CourseUpdate {
	
	public void addProfNames(ArrayList<String> profNames, String courseID) throws Exception {
		ArrayList<Course> courses = (ArrayList<Course>) DatabaseHandler.getCourseData(); 
		for (Course course : courses) {
			if(course.getCourseID().equals(courseID)) {
				for(String profName : profNames) {
					course.addProfName(profName);
				}
			}
		}
		DatabaseHandler.updateCourseData(courses);
		
	}
	
	public void registerStudent(Student student, String courseID) throws Exception {
		ArrayList<Course> courses= (ArrayList<Course>) DatabaseHandler.getCourseData();
    	
		for(Course course : courses) {
    		if(course.getCourseID().equals(courseID)) {
    			course.addStudent(student);
    			course.reduceVacancy();
    		}
    	DatabaseHandler.updateCourseData(courses);
		}		

	}
	
	public void updateMaxVacancy(String courseID, int vacancy) throws Exception {
		ArrayList<Course> courses= (ArrayList<Course>) DatabaseHandler.getCourseData();
    	
		for(Course course : courses) {
    		if(course.getCourseID().equals(courseID)) {
    			course.setMaxVacancy(vacancy);
    		}
    	DatabaseHandler.updateCourseData(courses);
		}
	}
	
}
