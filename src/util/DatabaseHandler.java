package util;

import java.util.List;
import students.Student;
import courses.Course;
import results.Result;

public class DatabaseHandler{
	/**
	 * Retrieve student information
	 * @return Student's information
	 * @throws Exception
	 */
	public static List<Student> getStudentData() throws Exception{
		Database db = new StudentDatabase();
		return (List<Student>) db.getData(); //Checked by respective database
	}

	/**
	 * Update student information
	 * @param students Student objects
	 * @throws Exception
	 */
	
	public static void updateStudentData(List<Student> students) throws Exception{
		Database db = new StudentDatabase();
		db.updateData(students);
	}

	/**
	 * Retrieve course information
	 * @return Course information
	 * @throws Exception
	 */
	
	public static List<Course> getCourseData() throws Exception{
		Database db = new CourseDatabase();
		return (List<Course>) db.getData();
	}

	/**
	 * Update course information
	 * @param courses Course objects
	 * @throws Exception
	 */
	
	public static void updateCourseData(List<Course> courses) throws Exception{
		Database db = new CourseDatabase();
		db.updateData(courses);
	}

	/**
	 * Retrieve results
	 * @return Results
	 * @throws Exception
	 */
	
	public static List<Result> getResultData() throws Exception{
		Database db = new ResultDatabase();
		return (List<Result>) db.getData();
	}

	/**
	 * Update results
	 * @param results Result objects
	 * @throws Exception
	 */
	
	public static void updateResultData(List<Result> results) throws Exception{
		Database db = new ResultDatabase();
		db.updateData(results);
	}
}
