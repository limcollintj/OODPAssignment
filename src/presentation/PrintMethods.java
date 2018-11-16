package presentation;

import Exceptions.EntityNotFoundException;
import courses.CourseManager;
import results.ResultManager;
import students.StudentManager;
import util.Scan;

/**
 * 
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class PrintMethods {

	/**
	 * Prints course statistics
	 * @throws Exception
	 */
	public static void printCourseStatistics(){
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
			System.out.println(e.getMessage());
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
	public static void printAllCourses(){
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
	public static void printAllLessons(String courseID){
		try {
			new CourseManager().printLessons(courseID);
		}
		catch (EntityNotFoundException e) {
			System.out.println("Invalid ID");
		}
		catch(Exception e) {
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
			
			String courseID,lessonID;
			
			System.out.println("Please enter course ID");
			courseID = Scan.readString();
			
			System.out.println("Please enter lesson ID");
			lessonID = Scan.readString();
			
		
			
			new CourseManager().printLesson(courseID, lessonID);
		}
		catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}