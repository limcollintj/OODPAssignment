package presentation;

import java.util.ArrayList;

import courses.*;
import functionalityClasses.AddToContainer;
import functionalityClasses.ExistsInContainer;
import students.Student;
import students.StudentManager;
import lessons.*;
import util.Container;
import util.DataBaseManager;
import util.Scan;
import students.StudentContainer;


public class AddMethods {

	/**
	 * Adds student to a course
	 */
	public static void addStudent(Container container){
		String name, id;
		boolean studentExists;
		do {
			System.out.println("Enter student's name: ");
			name = Scan.readString();
			System.out.println("Enter student's matric number: ");
			id = Scan.readString();
			if(studentExists = container.exists(id)) {
				System.out.println("Student already exists. Please use another matric number.");
			}
		} while(studentExists);
		Student student = new Student(name, id);
		//Adds to container after all necessary attributes are keyed in
		new AddToContainer().add(container, student);
		container.printAll();
	}

	/**
	 * Add a new course
	 * @throws Exception
	 */
	public static void addCourse(Container container) throws Exception{
		// Add course
		boolean courseExists;
		String courseID;
		do {
			System.out.println("Enter course ID: ");
			courseID = Scan.readString();
			if(courseExists= new ExistsInContainer().exists(container, courseID)) {
				System.out.println("Course ID already exists. Please choose another course ID.");
			}
		}while(courseExists);
		System.out.print("Enter course name: ");
		String courseName = Scan.readString();
		System.out.println("Enter Maximum Vacancy for the course");
		int maxVacancy = Scan.readInteger();

		CourseManager cm = new CourseManager();
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
			ArrayList<Integer> tutorialVacancies = new ArrayList<Integer>();
			do {
				sum = 0;
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
			//Adding tutorials
			for(int i = 0; i < tutorialIDs.size(); i++) {
				cm.addLesson(courseID, 3, tutorialIDs.get(i), tutorialVacancies.get(i));
			}
		}

		System.out.println("Do you want to add lab? Y/N");
		if(Scan.readString().toLowerCase().charAt(0) == 'y') {
			ArrayList<Integer> labVacancies = new ArrayList<Integer>();
			ArrayList<String> labIDs = new ArrayList<String>();
			do {
				sum = 0;
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
					System.out.println("Any other labs? Y/N");
				} while(Scan.readString().toLowerCase().charAt(0) == 'y');
				if(sum != maxVacancy) {
					System.out.println("Total lab vacancy must be equals to course vacancy!"
							+ "\nPlease try again.");
				}
			} while(sum != maxVacancy);
			for(int j = 0; j < labIDs.size(); j++) {
				cm.addLesson(courseID, 2, labIDs.get(j), labVacancies.get(j));
			}
		}	
		
		
		Course course = new Course(courseID, courseName);
		new AddToContainer().add(container, courseID);

	}

	/**
	 * Add a new lesson (Tutorial/Lab) to a course
	 * @param courseID Course ID
	 * @throws Exception
	 */
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

	/**
	 * Add professors in charge of a course
	 * @return A list of professors in charge of a course
	 */	
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

	/**
	 * Adds student to a particular Tutorial/Lab group in a course
	 * @throws Exception
	 */
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

