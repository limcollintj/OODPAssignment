package functionalityClasses;

import students.Student;

import java.util.ArrayList;

import courses.Course;
import util.DatabaseHandler;

public class StudentCRUDByID implements CRUDByID{
	

	@Override
	public void createByID(String id) throws Exception{
		FindStudentByID fs = new FindStudentByID();
		if(fs.getByID(id) == null) {
			Course newCourse = new Course(id); 
			ArrayList<Course> courseList = (ArrayList<Course>)DatabaseHandler.getCourseData();
			courseList.add(newCourse);
			DatabaseHandler.updateCourseData(courseList);
		}else {
			throw new Exception("Already exists");
		}
	}
	
	@Override
	public void readByID(String id) throws Exception{
		FindStudentByID fs = new FindStudentByID();	
		
	}
	
	@Override
	public void updateByID(String id) {
		FindStudentByID fs = new FindStudentByID();
		//TODO: Determine all possible updates
	}
	
	@Override
	public void deleteByID(String id) throws Exception {
		FindStudentByID fs = new FindStudentByID();
		ArrayList<Student> studentList = (ArrayList<Student>)DatabaseHandler.getStudentData();
		for(Student student : studentList) {
			if(student.getStudentID().equals(id)) {
				studentList.remove(student);
				DatabaseHandler.updateStudentData(studentList);
				break;
			}
		}
	}
}
