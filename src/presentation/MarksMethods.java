package presentation;

import courses.CourseManager;
import courses.Course;
import results.ResultManager;
import util.Scan;
import functionalityClasses.CourseCRUDByID;

public class MarksMethods {

	// Edit course weightages
	public static void editCourseWeightage() throws Exception {

		try {
			CourseManager cm = new CourseManager();

			// Enter course assessment weightage.
			System.out.print("Enter course ID: ");
			String courseID = Scan.readString();

			System.out.print("Enter coursework weightage: ");
			int cwWeightage = Scan.readInteger();
			cm.setCourseworkWeightage(courseID, cwWeightage);
			
			if(cwWeightage!=0) {
			System.out.print("Enter class participation weightage: ");
			}
			
		    // TODO: Add a check here for whether course work has sub components
			int cpWeightage = Scan.readInteger();
			cm.setClassParticipationWeightage(courseID, cpWeightage);
			System.out.println("Course Assesment components updated.");
		}catch(Exception e) {
			System.out.println(e);
		}

	}

	// Enter Exam Marks 
	public static void enterExamMarks() throws Exception {
		try {
			ResultManager rm = new ResultManager();

			System.out.print("----- Coursework Mark ------\n"
					+ "Enter Course ID:");
			String courseID = Scan.readString();
			System.out.print("Enter Student ID: ");
			String studentID = Scan.readString();
			Course course = new CourseCRUDByID().readByID(courseID);

			if(course.getEXWeightage() != 0) {
				System.out.print("Enter examination marks: ");
				double examinationMarks = Scan.readDouble();
				rm.updateResult(courseID, studentID, examinationMarks, 1);
			}
			
			if(course.getCWWeightage() != 0) {
				System.out.print("Enter coursework marks: ");
				double courseworkMarks = Scan.readDouble();
				rm.updateResult(courseID, studentID, courseworkMarks, 2);
			}
			
			if(course.getASWeightage() != 0) {
				System.out.print("Enter assignment marks: ");
				double assignmentMarks = Scan.readDouble();
				rm.updateResult(courseID, studentID, assignmentMarks, 3);
			}
			if(course.getCPWeightage() != 0) {
				System.out.print("\nEnter class participation marks: ");
				double classPartMarks = Scan.readDouble();
				rm.updateResult(courseID, studentID, classPartMarks, 4);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
