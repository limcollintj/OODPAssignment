package presentation;

import Exceptions.AlreadyRegisteredException;
import Exceptions.EntityNotFoundException;
import Exceptions.VacancyFullException;
import courses.Course;
import courses.CourseManager;
import students.Student;
import students.StudentManager;
import util.Scan;

/**
 * Boundary layer holding all the registration methods
 * 
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class RegisterMethods {

	/**
	 * Registers a student for a course
	 */
	public static void registerCourse() {
		try {
			// Enter studentID
			System.out.println("Enter Student ID");
			String studentID = Scan.readString(); 

			// Finds the student, throws exception if student does not exist
			Student student = new StudentManager().getStudent(studentID);
			if(student == null) {
				System.out.println("The student is not found in our database. ");
			} else {

				// Enter CourseID
				System.out.println("Enter Course ID you want to add student to");
				String courseID = Scan.readString(); 

				// Finds the course and throws exception if course is not found
				if(new CourseManager().getCourse(courseID) == null) {
					throw new EntityNotFoundException();
				}

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
					do {	//Get a valid ID from the user
						System.out.println("Please register student for tutorial. ");
						cm.printTutorials(course);
						System.out.print("Enter tutorial ID: ");
						tutorialID = Scan.readString();
					}while(!sm.registerStudentToLesson(studentID, courseID, tutorialID));
				}	
			}
		} catch (EntityNotFoundException e) {
			System.out.println("Please enter a valid id");
			registerCourse();
		} catch (VacancyFullException e) {
			System.out.println(e.getMessage()); 
		} catch(AlreadyRegisteredException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e); 
		}

	}
}
