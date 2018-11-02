package presentation;

import courses.CourseManager;
import results.ResultManager;
import util.Scan;

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
			System.out.print("Enter class participation weightage: ");

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

			System.out.print("Enter assignment marks: ");
			double assignmentMarks = Scan.readDouble();

			rm.updateResult(courseID, studentID, assignmentMarks, 2);
			System.out.print("\nEnter class participation marks: ");

			double classPartMarks = Scan.readDouble();
			rm.updateResult(courseID, studentID, classPartMarks, 3);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
