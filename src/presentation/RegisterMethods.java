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
		new CourseManager().registerStudent(student, courseID);
	}
	

}
