package presentation;

import java.util.Scanner;

import Exceptions.EntityNotFoundException;
import courses.CourseManager;
import results.ResultManager;
import students.StudentManager;
import util.Scan;

public class PrintMethods {


	// Prints Course Statistics

	/**
	 * Prints course statistics
	 * @throws Exception
	 */
	public static void printCourseStatistics() throws Exception {
		try {
			System.out.print("Enter course ID: ");
			String courseID = Scan.readString();
			new ResultManager().printCourseStatistics(courseID);
		}catch(Exception e) {
			System.out.print(e);
		}
	}

	// Prints Exam marks

	/**
	 * Prints exam marks by students
	 * @throws Exception
	 */
	public static void printExamMark(){
		try {
			System.out.print("----- Exam Result ------"
					+ "\nEnter student ID: ");
			String studentID = Scan.readString();
			System.out.print("Enter course ID: ");
			String courseID = Scan.readString();
			System.out.print("Enter exam marks: ");
			double exMark = Scan.readDouble();

			new ResultManager().updateResult(courseID, studentID, exMark, 1);
		}catch(Exception e) {
			System.out.print(e);
		}
	}


	// Prints Students registered in a course

	/**
	 * Prints a list of students registered in a course
	 * @throws Exception
	 */
	public static void printStudentList(){
		try {
			System.out.print("----- Registered Students ------\n"
					+ "Enter Course ID: ");
			String courseID = Scan.readString();
			new CourseManager().printStudentsRegisteredInCourse(courseID);
		} catch(Exception e) {
			System.out.print(e);
		}
	}
	
	


	// Prints vacancy in a course

	/**
	 * Prints the vacancy in a course
	 * @throws Exception
	 */
	public static void printVacancy() throws Exception {
		try {
			System.out.print("----- Course Vacancy -----\n"
					+ "Enter Course ID: ");
			String courseID = Scan.readString();
			System.out.print("Vacancy: ");
			new CourseManager().printVacancy(courseID);
		}catch(Exception e) {
			System.out.print(e);
		}
	}

	// Prints Student Transcripts

	/**
	 * Prints the student transcript
	 * @throws Exception
	 */
	public static void printStudentTranscript() {
		try {
			ResultManager rm = new ResultManager();

			System.out.print("Enter student ID: ");
			String studentID = Scan.readString();
			
			// Check if student is valid
			if(new StudentManager().getStudent(studentID) == null) {
				throw new EntityNotFoundException();
			}
				
			
			rm.printTranscript(studentID);
		}
		catch (EntityNotFoundException e) {
			System.out.println("Student not found");
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}

	// Print All Courses

	/**
	 * Prints a list of all courses
	 * @throws Exception
	 */
	public static void printAllCourses() throws Exception {
		try {
			CourseManager cm = new CourseManager();
			cm.printCourses();
		}catch(Exception e) {
			System.out.print(e);
		}
	}

	// Print all students

	/**
	 * Prints a list of all students
	 * @throws Exception
	 */
	public static void printAllStudents(){
		try {
			StudentManager sm = new StudentManager(); 

			sm.printStudents();
		}catch(Exception e) {
			System.out.print(e);
		}
	}

	//Prints All Lessons

	/**
	 * Prints a list of all Tutorial/Laboratory sessions in a course
	 * @param courseID Course ID
	 * @throws Exception
	 */
	public static void printAllLessons(String courseID) throws Exception{
		try {
			new CourseManager().printLessons(courseID);
		}catch(Exception e) {
			System.out.print(e);
		}
	}



	// Prints specific Lesson

	/**
	 * Prints lessons
	 * @param courseID Course ID
	 * @param lessonID Tutorial/Laboratory ID
	 * @throws Exception
	 */
	public static void printLesson() {
		
		try {
			Scanner sc = new Scanner(System.in);
			String courseID,lessonID;
			
			System.out.println("Please enter course ID");
			courseID = sc.nextLine(); 
			
			System.out.println("Please enter course ID");
			lessonID = sc.nextLine();
			
			sc.close();
			
			
			new CourseManager().printLesson(courseID, lessonID);
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}