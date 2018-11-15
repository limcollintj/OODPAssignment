package presentation;

import Exceptions.AlreadyRegisteredException;
import Exceptions.EntityNotFoundException;
import Exceptions.VacancyFullException;
import courses.Course;
import courses.CourseManager;
import students.Student;
import students.StudentManager;
import util.Container;
import util.Scan;

public class RegisterMethods {
	
	
	// Registers student for a course 
	// Register Student for a course

	/**
	 * Registers a student for a course
	 * @throws Exception
	 */

	public static void registerCourse() {
		
		
		try {
			
		
		// Enter studentID
		System.out.println("Enter Student ID");
		String studentID = Scan.readString(); 
		
		// Finds the student, throws exception if student does not exist
		Student student = new StudentManager().getStudent(studentID);
		
		
		// Enter CourseID
		System.out.println("Enter Course ID you want to add student to");
		String courseID = Scan.readString(); 
		
		// Finds the course and throws exception if course is not found
		Course course = new CourseManager().getCourse(courseID);
		
		
		// Registers the student to the course

		StudentManager sm = new StudentManager();
		CourseManager cm = new CourseManager();
		
		// Check if the student is already registered in the course 
		if(course.getregisteredStudentIDs().contains(studentID)) {
			throw new AlreadyRegisteredException("course"); 
		}
		
		// Register student throws exception if the course is full, and results will be automatically added in register student
		cm.registerStudent(student, courseID);
		sm.registerCourse(studentID, course);
		
		
		// register student to lesson throws vacancy full exception if lab is full 
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
	
	
}
		
		catch (EntityNotFoundException e) {
			System.out.println("Please enter a valid id");
			registerCourse();
		}
		catch (VacancyFullException e) {
			e.getMessage(); 
		}
		catch(AlreadyRegisteredException e) {
			e.getMessage();
		}
		catch (Exception e) {
			e.getMessage(); 
		}
		
	}
	

}
