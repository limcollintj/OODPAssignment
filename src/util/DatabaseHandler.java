package util;

import java.util.List;
import students.Student;
import courses.Course;
import results.Result;

public class DatabaseHandler {
	public List<Student> getStudentData() throws Exception{
		Database db = new StudentDatabase();
		return (List<Student>) db.getData(); //Checked by respective database
	}
	
	public void updateStudentData(List<Student> students) throws Exception{
		Database db = new StudentDatabase();
		db.updateData(students);
	}
	
	public List<Course> getCourseData() throws Exception{
		Database db = new CourseDatabase();
		return (List<Course>) db.getData();
	}
	
	public void updateCourseData(List<Course> courses) throws Exception{
		Database db = new CourseDatabase();
		db.updateData(courses);
	}
	
	public List<Result> getResultData() throws Exception{
		Database db = new ResultDatabase();
		return (List<Result>) db.getData();
	}
	
	public void supdateResultData(List<Result> results) throws Exception{
		Database db = new ResultDatabase();
		db.updateData(results);
	}
}
