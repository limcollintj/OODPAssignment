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
			StudentManager sm = new StudentManager();
			sm.addNewStudent(name, id);
			sm.printStudents();
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
			//TODO: Do check here
			System.out.print("Enter course name: ");
			String courseName = Scan.readString();
			System.out.println("Enter Maximum Vacancy for the course");
			int maxVacancy = Scan.readInteger();

			// addProfs() returns an arraylist of profs
			cm.addNewCourse(courseID, addProfs());
			cm.updateMaxVacancy(courseID, maxVacancy);
			cm.updateCourseName(courseID, courseName);


			System.out.print("Enter Lecture ID: ");
			String lectureID = Scan.readString();
			new CourseManager().addLesson(courseID, 1, lectureID, maxVacancy);

			int sum;
			ArrayList<String> tutorialIDs = new ArrayList<String>();
			System.out.println("Do you want to add tutorials? Y/N");
			if(Scan.readString().toLowerCase().charAt(0) == 'y') {
				do {
					sum = 0;
					ArrayList<Integer> tutorialVacancies = new ArrayList<Integer>();
					tutorialIDs = new ArrayList<String>();
					String tutorialID; int tutorialVacancy; 
					do {
						boolean validLesson = true;
						System.out.print("Enter tutorial ID: ");
						tutorialID = Scan.readString();
						for(String id : tutorialIDs) {
							if(id.equals(tutorialID)) {
								validLesson = false;
								break;
							}
						}
						if(tutorialID.equals(lectureID)) {
							validLesson = false;
						}
						if(validLesson) {
							System.out.print("Enter tutorial vacancy: ");
							tutorialVacancy = Scan.readInteger();
							tutorialIDs.add(tutorialID);
							tutorialVacancies.add(tutorialVacancy);
							sum += tutorialVacancy;
							System.out.println("Total Lab Vacancies: " + sum
									+ "\nCourse Vacancy: " + maxVacancy);
						} else {
							System.out.println("ID already exists.");
						}
						System.out.println("Any other tutorials? Y/N");
					} while(Scan.readString().toLowerCase().charAt(0) == 'y');
					if(sum != maxVacancy) {
						System.out.println("Total tutorial vacancy must be equals to course vacancy!"
								+ "\nPlease try again.");
					}
				} while(sum != maxVacancy);
			}
			
			System.out.println("Do you want to add lab? Y/N");
			if(Scan.readString().toLowerCase().charAt(0) == 'y') {
				do {
					sum = 0;
					ArrayList<Integer> labVacancies = new ArrayList<Integer>();
					ArrayList<String> labIDs = new ArrayList<String>();
					String labID; int labVacancy; 
					do {
						boolean validLesson = true;
						System.out.print("Enter lab ID: ");
						labID = Scan.readString();
						for(String id : labIDs) {
							if(id.equals(labID)) {
								validLesson = false;
								break;
							}
						}
						for(String id : tutorialIDs) {
							if(id.equals(labID)) {
								validLesson = false;
								break;
							}
						}
						if(labID.equals(lectureID)) {
							validLesson = false;
						}
						if(validLesson) {
							System.out.print("Enter lab vacancy: ");
							labVacancy = Scan.readInteger();
							labIDs.add(labID);
							labVacancies.add(labVacancy);
							sum += labVacancy;
							System.out.println("Total Lab Vacancies: " + sum
									+ "\nCourse Vacancy: " + maxVacancy);
						}
						else {
							System.out.println("ID already exists. ");
						}
						System.out.println("Any other Lessons? Y/N");
					} while(Scan.readString().toLowerCase().charAt(0) == 'y');
					if(sum != maxVacancy) {
						System.out.println("Total lab vacancy must be equals to course vacancy!"
								+ "\nPlease try again.");
					}
				} while(sum != maxVacancy);
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
			ArrayList<String> profNames = new ArrayList<String>(); 
			System.out.print("ENter the name of main professor: ");
			profNames.add(Scan.readString());
			System.out.println("Enter Prof Names for the course, enter -1 after the last entry");
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
		System.out.print("Enter Student ID: ");
    	String studentID = Scan.readString(); 
    	System.out.print("Enter Course ID: ");
    	String courseID = Scan.readString();
    	System.out.print("Enter lesson ID: ");
    	String lessonID = Scan.readString();
		
		try {
			new StudentManager().registerStudentToLesson(studentID, courseID, lessonID);
		}catch(Exception e) {
			System.out.print(e);
		}
	}
}

