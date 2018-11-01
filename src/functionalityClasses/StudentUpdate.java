package functionalityClasses;

import java.util.ArrayList;

import courses.Course;
import students.Student;
import util.DatabaseHandler;

public class StudentUpdate {
	public void addName(String id, String name) throws Exception {
		ArrayList<Student> studentList = (ArrayList<Student>)DatabaseHandler.getStudentData();
		for(Student student : studentList) {
			if(student.getStudentID().equals(id)) {
				student.setName(name);
				DatabaseHandler.updateStudentData(studentList);
				break;
			}
		}
		
	}
	
	public void registerCourse(Course course, String studentId) throws Exception {
		//Do checks to see if student already registered
    	ArrayList<Student> students = (ArrayList<Student>) DatabaseHandler.getStudentData();
    	for(Student stud : students) {
    		if(stud.getStudentID().equals(studentId)) {
    			stud.addCourse(course);	
    		}
    	}
    	DatabaseHandler.updateStudentData(students);
	}
} 
