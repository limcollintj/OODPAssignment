package util;

import java.util.List;
import students.Student;
import courses.Course;
import results.Result;

public class DatabaseHandler{
	
	public static List<Student> getStudentData() throws Exception{
		Database db = new StudentDatabase();
		return (List<Student>) db.getData(); //Checked by respective database
	}
	
	public static void updateStudentData(List<Student> students) throws Exception{
		Database db = new StudentDatabase();
		db.updateData(students);
	}
	
	public static List<Course> getCourseData() throws Exception{
		Database db = new CourseDatabase();
		return (List<Course>) db.getData();
	}
	
	public static void updateCourseData(List<Course> courses) throws Exception{
		Database db = new CourseDatabase();
		db.updateData(courses);
	}
	
	public static List<Result> getResultData() throws Exception{
		Database db = new ResultDatabase();
		return (List<Result>) db.getData();
	}
	
	public static void updateResultData(List<Result> results) throws Exception{
		Database db = new ResultDatabase();
		db.updateData(results);
	}
}
