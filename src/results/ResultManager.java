package results;

import java.util.ArrayList;

import functionalityClasses.CRUDByID;
import functionalityClasses.CourseCRUDByID;
import util.DataBaseManager;
import util.DatabaseHandler;
import util.GradeCalculator;
import courses.*;

/**
 * <code>ResultManager</code> is a control class that handles operations done on the <code>Result</code> class.
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class ResultManager {

    /**
     * This Result Manager's <code>ArrayList</code> of Result objects.
     */
	ArrayList<Result> results;

    /**
     * This Result Manager's <code>CRUDByID</code> object.
     */
	CRUDByID courseCRUD;


    /**
     * Creates a new ResultManager object.
     * @throws Exception
     */
	public ResultManager() throws Exception {
		this.results = (ArrayList<Result>) DatabaseHandler.getResultData();
		courseCRUD = new CourseCRUDByID();
	}

    /**
     * Creates a new Result object for a given Student registered for a Course.
     * @param courseID the Course ID of the given <code>Course</code>.
     * @param studentID the Student ID of the given <code>Student</code>.
     * @return a Result object
     */
	private Result buildResult(String courseID, String studentID) {
		courseCRUD = new CourseCRUDByID();
		Result results = new Result(courseID, studentID, "overall");
		results.addSubComponent(new ResultComponent("exam"));
		results.addSubComponent(new ResultComponent("coursework"));
		results.getSubComponent().get(1).addSubComponent(new ResultComponent("assignment"));
		results.getSubComponent().get(1).addSubComponent(new ResultComponent("class participation"));
		return results;
		
	}

    /**
     * Creates a new Result object for a given Student registered for a Course.
     * This Result object is also added to the Results Database.
     * @param courseID the Course ID of the given <code>Course</code>.
     * @param studentID the Student ID of the given <code>Student</code>.
     * @throws Exception
     */
	public void addResult(String courseID, String studentID) throws Exception {
		ResultManager rm = new ResultManager();
		Result result = rm.buildResult(courseID, studentID); 
		this.results.add(result);
		
		DatabaseHandler.updateResultData(this.results);
	}

    /**
     *
     * @param courseID
     * @param studentID
     * @param mark
     * @param option
     * @throws Exception
     */
	public void updateResult(String courseID, String studentID, double mark, int option) throws Exception{
		int index = getResultIndex(courseID, studentID);
		if(option >3 | option < 1) {
			throw new IllegalArgumentException("Option parameter can only be 1, 2 or 3.");
		}
		switch(option) {
		case 1:
			setEXResult(index, mark);
			break;
		case 2:
			setCWResult(index, mark);
		case 3:	//first .get(1) returns coursework arraylist
			setASResult(index, mark);
			break;
		case 4:
			setCPResult(index, mark);
			break;
		}
		updateAllResult(courseID, studentID);
		
		DatabaseHandler.updateResultData(this.results);
		System.out.println("Result updated");
	}

    /**
     * Prints the result transcript of a given Student.
     * The transcript includes all the Courses the Student has registered for and the overall GPA.
     * @param studentID ID of the <code>Student</code>
     * @throws Exception
     */
	public void printTranscript(String studentID) throws Exception{
		System.out.println("----- Student Transcript ------"
				+ "\nStudent ID: " + studentID);
		ArrayList<String> gradeList = new ArrayList<String>();
		for(Result result : this.results) {
			if(result.getStudentID().equals(studentID)) {
				updateAllResult(result.getCourseID(), studentID);
				result.printInfo();
				gradeList.add(GradeCalculator.calGrades(result.getMark()));
			}
		}
		
		System.out.println("Your Overall GPA is "+ GradeCalculator.calGPA(gradeList));
	}

    /**
     * Prints the course statistics of a given Course.
     * The statistics include the name, ID, number of students and average score in the Course.
     * @param courseID ID of the <code>Course</code>
     * @throws Exception
     */
	public void printCourseStatistics(String courseID) throws Exception{
		
		Course course = (Course) courseCRUD.readByID(courseID);
		double sum = 0;
		int count = 0;
		for(Result result : this.results) {
			if(result.getCourseID().equals(courseID)) {
				sum += result.getMark();
				count++;
			}
		}
		
		System.out.println("----- Course Statistics ------"
				+ "\nCourse Name " + course.getCourseName() 
				+ "\nCourse ID: " + courseID
				+ "\nNumber of students: " + count
				+ "\nAverage Score: " + sum/count);
	}

    /**
     * todo IDK?
     * @param courseID
     * @param studentID
     * @throws Exception
     */
	private void updateAllResult(String courseID, String studentID) throws Exception{
		Course course = (Course) courseCRUD.readByID(courseID);
		int index = getResultIndex(courseID, studentID);
		if(index != -1) {
			Result result = this.results.get(index);
			double cwComponent = course.getASWeightage()*getASResult(result)/100 
					+ course.getCPWeightage()*getCPResult(result)/100;
			setCWResult(index, cwComponent);
			double overall = course.getEXWeightage()*getEXResult(result)/100
					+ course.getCWWeightage()*getCWResult(result)/100;
			
			// TODO: check whether student is registered in course
			setOverallResult(index, overall);
			
			DatabaseHandler.updateResultData(this.results);
		}
	}

    /**
     * Gets the Assignment mark of a given Result object.
     * @param result <code>Result</code> object of interest.
     * @return
     */
	private double getASResult(Result result) {
		return result.getSubComponent().get(1).getSubComponent().get(0).getMark();
	}

    /**
     * Gets the Class Participation mark of a given Result object.
     * @param result <code>Result</code> object of interest.
     * @return
     */
	private double getCPResult(Result result) {
		return result.getSubComponent().get(1).getSubComponent().get(1).getMark();
	}

    /**
     * Gets the CourseWork mark of a given Result object.
     * @param result <code>Result</code> object of interest.
     * @return
     */
	private double getCWResult(Result result) {
		return result.getSubComponent().get(1).getMark();
	}

    /**
     * Gets the Exam mark of a given Result object.
     * @param result <code>Result</code> object of interest.
     * @return
     */
	private double getEXResult(Result result) {
		return result.getSubComponent().get(0).getMark();
	}

    /**
     * Gets the overall mark of a given Result object.
     * @param result <code>Result</code> object of interest.
     * @return
     */
	private double getOverallResult(Result result) {
		return result.getMark();
	}

    /**
     * Gets the location of a given <code>Result</code> object in the result ArrayList
     * @param courseID the ID of the Course a Student has registered for
     * @param studentID the ID of the Student.
     * @return the index of the <code>Result</code> in the ArrayList.
     */
	private int getResultIndex(String courseID, String studentID) {
		for(Result result : this.results) {
			if(result.getCourseID().equals(courseID) && result.getStudentID().equals(studentID)) {
				return this.results.indexOf(result);
			}
		}
		return -1;
	}

    /**
     * Sets the Assignment Result of a given Result object.
     * @param index index of the <code>Result</code> object.
     * @param mark the new Assignment mark.
     */
	private void setASResult(int index, double mark) {
		this.results.get(index).getSubComponent().get(1).getSubComponent().get(0).setMark(mark);
	}

    /**
     * Sets the Class Participation Result of a given Result object.
     * @param index index of the <code>Result</code> object.
     * @param mark the new Class Participation mark.
     */
	private void setCPResult(int index, double mark) {
		this.results.get(index).getSubComponent().get(1).getSubComponent().get(1).setMark(mark);
	}

    /**
     * Sets the CourseWork Result of a given Result object.
     * @param index index of the <code>Result</code> object
     * @param mark the new CourseWork mark.
     */
	private void setCWResult(int index, double mark) {
		this.results.get(index).getSubComponent().get(1).setMark(mark);
	}

    /**
     * Sets the Exam Result of a given Result object.
     * @param index index of the <code>Result</code> object
     * @param mark the new Exam mark.
     */
	private void setEXResult(int index, double mark) {
		this.results.get(index).getSubComponent().get(0).setMark(mark);
	}

	/**
     * Sets the overall mark of a given Result object
     * @param index index of the <code>Result</code> object
     * @param mark the new overall marks.
     */
	private void setOverallResult(int index, double mark) {
		this.results.get(index).setMark(mark);
	}	
}
