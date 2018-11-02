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
				break;
			}
		}
		DatabaseHandler.updateCourseData(courses);
	}
	
	public void registerStudent(Student student, String courseID) throws Exception {
		ArrayList<Course> courses= (ArrayList<Course>) DatabaseHandler.getCourseData();
		for(Course course : courses) {
    		if(course.getCourseID().equals(courseID)) {
    			course.reduceVacancy(); //Does the vacancy check
    			course.addStudent(student);
    			course.getLessons().get(0).addStudent(student.getStudentID());
    			break;
    		}
		}
		DatabaseHandler.updateCourseData(courses);
	}
	
	public void updateMaxVacancy(String courseID, int vacancy) throws Exception {
		ArrayList<Course> courses= (ArrayList<Course>) DatabaseHandler.getCourseData();
    	
		for(Course course : courses) {
    		if(course.getCourseID().equals(courseID)) {
    			course.setMaxVacancy(vacancy);
    			break;
    		}
		}
		DatabaseHandler.updateCourseData(courses);
	}
	
	public void updateCourseName(String courseID, String name) throws Exception{
		ArrayList<Course> courses= (ArrayList<Course>) DatabaseHandler.getCourseData();
		for(Course course : courses) {
    		if(course.getCourseID().equals(courseID)) {
    			course.setCourseName(name);
    			break;
    		}
		}
		DatabaseHandler.updateCourseData(courses);
	}
}
