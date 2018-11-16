package functionalityClasses;

import courses.Course;
import util.DatabaseHandler;
import java.util.ArrayList;

import Exceptions.EntityNotFoundException;
import Exceptions.AlreadyExistsException;

/**
 * Class for creating, reading, updating and deleting of courses by ID.
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class CourseCRUDByID implements CRUDByID{

	/**
	 * Create course by ID
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void createByID(String id) throws Exception{

		Course newCourse = new Course(id); 
		ArrayList<Course> courseList = (ArrayList<Course>)DatabaseHandler.getCourseData();
		try{
			if(readByID(id) instanceof Course) {	//Check to see if the course already exists
				throw new AlreadyExistsException("Course");
			}
		}catch(Exception e) {}
		courseList.add(newCourse);
		DatabaseHandler.updateCourseData(courseList);
	}

	/**
	 * Read course by ID
	 * 
	 * @param id ID of desired <code>Course</code> object 
	 * @return Desired <code>Course</code> object corresponding to id
	 * @throws Exception
	 */
	@Override
	public Course readByID(String id) throws Exception{
		for (Course temp : DatabaseHandler.getCourseData() ) {
			if(temp.getCourseID().equals(id)) {
				return temp;
			}
		}
		return null; //Returns null if Course is not found
	}

	/**
	 * Update course by ID
	 * 
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void updateByID(String id, Object o) throws Exception{
		Course course = this.readByID(id);
		ArrayList<Course> courseList = (ArrayList<Course>)DatabaseHandler.getCourseData();
		int courseIndex = courseList.indexOf(course);	//Returns -1 if course object not found
		if(o instanceof Course && courseIndex != -1) {	//Checks if o is of Course type
			courseList.set(courseIndex, (Course)o);
			DatabaseHandler.updateCourseData(courseList);
		} else { //Throws exception if entity not found
			throw new EntityNotFoundException();
		}
	}

	/**
	 * Delete course by ID
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void deleteByID(String id) throws Exception{
		if(this.readByID(id) instanceof Course) {
			ArrayList<Course> courseList = (ArrayList<Course>)DatabaseHandler.getCourseData();
			for(Course course : courseList) {	//Iterates through the ArrayList to find and remove the entity class
				if(course.getCourseID().equals(id)) {
					courseList.remove(course);
					break;
				}
			}
			DatabaseHandler.updateCourseData(courseList);
		} else {	//Throws an exception if object is not found
			throw new EntityNotFoundException();
		}
	}
}
