package presentation;

import java.util.ArrayList;

import courses.*;
import students.StudentManager;
import lessons.*;

import util.Scan;


public class AddMethods {


	public static void addStudent(){
		try {
			System.out.println("Enter student's name: ");
			String name = Scan.readString();
			System.out.println("Enter student's matric number: ");
			String id = Scan.readString();
			new StudentManager().addNewStudent(name, id);
		} catch(Exception e) {
			System.out.print(e);
		}
	}

	public static void addCourse() throws Exception{
		try {
			CourseManager cm = new CourseManager();

			// Add course
			System.out.println("Enter course ID: ");
			String courseID = Scan.readString();
			System.out.println("Enter Maximum Vacancy for the course");
			int maxVacancy = Scan.readInteger();

			// addProfs() returns an arraylist of profs
			cm.addNewCourse(courseID, addProfs());
			cm.updateMaxVacancy(courseID, maxVacancy);


			System.out.print("Enter Lecture ID: ");
			String lessonID = Scan.readString();
			System.out.print("Enter lecture vacancy: ");
			int vacancy = Scan.readInteger();
			new CourseManager().addLesson(courseID, 1, lessonID, vacancy);

			System.out.println("Any other Lessons? Y/N");
			while(Scan.readString().toLowerCase().charAt(0) == 'y') {
				addLesson(courseID);
				System.out.println("Any other Lessons? Y/N");
			}
		}catch(Exception e) {
			System.out.print(e);
		}
	}

	public static void addLesson(String courseID) throws Exception{
		
		try {
			int choice;
			do {
				System.out.print("Choose lesson type (1:Lecture, 2: Lab, 3: tutorial): ");
				choice = Scan.readInteger();
			} while(choice < 0 || choice > 3);
			System.out.print("Enter lesson ID: ");
			String lessonID = Scan.readString();
			System.out.print("Enter lesson vacancy: ");
			int vacancy = Scan.readInteger();
			new CourseManager().addLesson(courseID, choice, lessonID, vacancy);
		}catch(Exception e) {
			System.out.print(e);
		}
	}

	private static ArrayList<String> addProfs() {
		try {
			System.out.println("Enter Prof Names for the course, enter -1 after the last entry");

			ArrayList<String> profNames = new ArrayList<String>(); 
			String profName;
			do {
				System.out.println("Enter Prof Name");
				profName = Scan.readString();
				if(!profName.equals("-1")) {
					profNames.add(profName);
				}
			}
			while(!profName.equals("-1"));

			return profNames;
		}catch(Exception e) {
			System.out.print(e);
		}
		return null;

	}

	public static void addStudentToLesson() throws Exception {
		System.out.print("Enter Student ID");
    	String studentID = Scan.readString(); 
    	System.out.println("Enter Course ID");
    	String courseID = Scan.readString();
    	System.out.println("Enter lesson ID");
    	String lessonID = Scan.readString();
    	
		
		try {
			new CourseManager().addStudentToLesson(studentID, courseID, lessonID);
		}catch(Exception e) {
			System.out.print(e);
		}
	}
}

