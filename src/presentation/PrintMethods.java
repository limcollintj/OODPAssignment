package presentation;

import courses.CourseManager;
import results.ResultManager;
import students.StudentManager;
import util.Scan;

public class PrintMethods {


	// Prints Course Statistics
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
	public static void printExamMark() throws Exception {
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
	public static void printStudentList() throws Exception {
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
	public static void printStudentTranscript() throws Exception {
		try {
			ResultManager rm = new ResultManager();

			System.out.print("Enter student ID: ");
			String studentID = Scan.readString();
			rm.printTranscript(studentID);
		}catch(Exception e) {
			System.out.print(e);
		}
	}

	// Print All Courses
	public static void printAllCourses() throws Exception {
		try {
			CourseManager cm = new CourseManager();
			cm.printCourses();
		}catch(Exception e) {
			System.out.print(e);
		}
	}

	// Print all students 
	public static void printAllStudents() throws Exception {
		try {
			StudentManager sm = new StudentManager(); 

			sm.printStudents();
		}catch(Exception e) {
			System.out.print(e);
		}
	}

	//Prints All Lessons
	public static void printAllLessons(String courseID) throws Exception{
		try {
			new CourseManager().printLessons(courseID);
		}catch(Exception e) {
			System.out.print(e);
		}
	}



	// Prints specific Lesson 
	public static void printLesson(String courseID, String lessonID) throws Exception{
		try {
			new CourseManager().printLesson(courseID, lessonID);
		} catch(Exception e) {
			System.out.print(e);
		}
	}

}