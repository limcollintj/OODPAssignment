package functionalityClasses;

import courses.Course;
import util.DatabaseHandler;
import java.util.ArrayList;

/**
 Class for creating, reading, updating and deleting of courses by ID.
 @author LFM
 @version 1.0
 @since 2018-11-05
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
			if(readByID(id) instanceof Course) {
				throw new Exception("Course Already Added\n");
			}
		}catch(Exception e) {}
		courseList.add(newCourse);
		DatabaseHandler.updateCourseData(courseList);
	}

	/**
	 * Read course by ID
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Course readByID(String id) throws Exception{

		for (Course temp : DatabaseHandler.getCourseData() ) {
			if(temp.getCourseID().equals(id)) {
				return temp;
			}
		}
		throw new Exception("Course not found.");

	}

	/**
	 * Update course by ID
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void updateByID(String id) throws Exception{

		if(this.readByID(id) instanceof Course) {
			//TODO: Find all possible updates
		} else {
			throw new Exception("Cannot find");
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
			for(Course course : courseList) {
				if(course.getCourseID().equals(id)) {
					courseList.remove(course);
					break;
				}
			}
			DatabaseHandler.updateCourseData(courseList);
		} else {
			throw new Exception("Cannot find");
		}
	}
}
