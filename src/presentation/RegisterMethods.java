package presentation;

import courses.Course;
import courses.CourseManager;
import students.Student;
import students.StudentManager;
import util.Scan;

public class RegisterMethods {
	
	
	// Registers student for a course 
	// Register Student for a course
	public static void registerCourse() throws Exception {
		System.out.println("Enter Student ID");
		String studentID = Scan.readString(); 
		
		Student student = new StudentManager().getStudent(studentID);
		
		System.out.println("Enter Course ID you want to add student to");
		String courseID = Scan.readString(); 
		Course course = new CourseManager().getCourse(courseID);
		
		new StudentManager().registerCourse(studentID, course);
		
		// Results will be automatically added in registerStudent
		new CourseManager().registerStudent(student, courseID);
		
		// Register for lecture
		// Call function which prints out ID and vacancies for tutorial and lab 
		// addlesson 
	
		
	}
	

}
