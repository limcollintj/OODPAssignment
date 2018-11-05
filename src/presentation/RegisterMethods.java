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
		
		StudentManager sm = new StudentManager();
		sm.registerCourse(studentID, course);
		// Results will be automatically added in registerStudent
		CourseManager cm = new CourseManager();
		cm.registerStudent(student, courseID);
		
		String labID;
		if(cm.hasLab(course)) {
			do {
			System.out.println("Please register student for lab. ");
			cm.printLabs(course);
			System.out.print("Enter lab ID: ");
			labID = Scan.readString();
			}while(!sm.registerStudentToLesson(studentID, courseID, labID));
		}
		
		String tutorialID;
		if(cm.hasTutorial(course)) {
			do {
			System.out.println("Please register student for tutorial. ");
			cm.printTutorials(course);
			System.out.print("Enter tutorial ID: ");
			tutorialID = Scan.readString();
			}while(!sm.registerStudentToLesson(studentID, courseID, tutorialID));
		}
		// Register for lecture
		// Call function which prints out ID and vacancies for tutorial and lab 
		// addlesson 
	
		
	}
	

}
