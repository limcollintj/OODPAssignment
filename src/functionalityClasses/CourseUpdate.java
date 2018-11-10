package functionalityClasses;

import java.util.ArrayList;

import courses.Course;
import students.Student;
import util.DatabaseHandler;

/**
 Class for updating courses.
 @author LFM
 @version 1.0
 @since 2018-11-05
 */

public class CourseUpdate {

	/**
	 * Add course professor names to courses.
	 * @param profNames
	 * @param courseID
	 * @throws Exception
	 */
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

	/**
	 * Register student for courses.
	 * @param student
	 * @param courseID
	 * @throws Exception
	 */
	
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

	/**
	 * Update courses' max vacancy.
	 * @param courseID
	 * @param vacancy
	 * @throws Exception
	 */
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

	/**
	 * Update name of courses.
	 * @param courseID
	 * @param name
	 * @throws Exception
	 */
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
