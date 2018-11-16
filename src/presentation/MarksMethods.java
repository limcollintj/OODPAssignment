package presentation;

import courses.CourseManager;
import courses.Course;
import results.ResultManager;
import util.Scan;
import functionalityClasses.CourseCRUDByID;
import functionalityClasses.CourseUpdate;


public class MarksMethods {

	// Edit course weightages

	/**
	 * Edits course weightage
	 * @throws Exception
	 */
	public static void editCourseWeightage(){

		try {
			CourseManager cm = new CourseManager();

			// Enter course assessment weightage.
			System.out.print("Enter course ID: ");
			String courseID = Scan.readString();
			int cwWeightage;
			int cpWeightage;
			do {
				System.out.print("Enter coursework weightage: ");
				cwWeightage = Scan.readInteger();
				if(cwWeightage > 100 || cwWeightage < 0) {
					System.out.println("Coursework weightage must be between 0 and 100.");
				}
			}while(cwWeightage > 100 || cwWeightage < 0);
			cm.setCourseworkWeightage(courseID, cwWeightage);
			System.out.println("Coursework weightage is set to " + cwWeightage);
			System.out.println("Exam weightage is set to " + (100-cwWeightage));
			
			if(cwWeightage!=0) {
				System.out.print("Do you want to add subcomponents under coursework? (Y/N)");
				Course course = new CourseManager().getCourse(courseID);
				char choice = Scan.readString().toLowerCase().charAt(0);
				if(choice == 'y') {
					new CourseUpdate().updateHaveSubComponent(courseID, true);
					do {
						System.out.print("Enter class participation weightage: ");
						cpWeightage = Scan.readInteger();
						if(cpWeightage > 100 || cpWeightage < 0) {
							System.out.println("Class participation weightage must be between 0 and 100.");
						}
					}while(cpWeightage > 100 || cpWeightage < 0);
					cm.setClassParticipationWeightage(courseID, cpWeightage);
					System.out.println("Assignment weightage is set to " + (100-cpWeightage));
					System.out.println("Class participation weightage is set to " + cpWeightage);
				} else {
					CourseUpdate cu = new CourseUpdate();
					cu.updateHaveSubComponent(courseID, false);
					cm.setClassParticipationWeightage(courseID, 0);
					
					
				}
				
			}
			System.out.println("Course Assesment components updated.");
		}catch(Exception e) {
			System.out.println(e);
		}

	}

	// Enter Exam Marks

	/**
	 * Enter course marks
	 * @throws Exception
	 */
	public static void enterExamMarks() {
		try {
			ResultManager rm = new ResultManager();

			System.out.print("----- Coursework Mark ------\n"
					+ "Enter Course ID:");
			String courseID = Scan.readString();
			System.out.print("Enter Student ID: ");
			String studentID = Scan.readString();
			Course course = new CourseCRUDByID().readByID(courseID);

			if(course.getEXWeightage() != 0) {
				double examinationMarks;
				do {
					System.out.print("Enter examination marks: ");
					examinationMarks = Scan.readDouble();
					rm.updateResult(courseID, studentID, examinationMarks, 1);
				}while(examinationMarks<0 || examinationMarks>100);
				
				
			}
			
			if(course.getCWWeightage() != 0) {
				double courseworkMarks;
				do {
					System.out.print("Enter coursework marks: ");
					courseworkMarks = Scan.readDouble();
					rm.updateResult(courseID, studentID, courseworkMarks, 2);
				}while(courseworkMarks<0 || courseworkMarks>100);
				
			}
			
			if(course.getASWeightage() != 0 && course.haveSubComponent()) {
				double assignmentMarks; 
				do {
					System.out.print("Enter assignment marks: ");
					assignmentMarks = Scan.readDouble();
					rm.updateResult(courseID, studentID, assignmentMarks, 3);
				}while(assignmentMarks<0 || assignmentMarks>100);
				
			}
			if(course.getCPWeightage() != 0 && course.haveSubComponent()) {
				double classPartMarks; 
				do {
					System.out.print("\nEnter class participation marks: ");
					classPartMarks = Scan.readDouble();
					rm.updateResult(courseID, studentID, classPartMarks, 4);
				}while(classPartMarks<0 || classPartMarks>100);
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
