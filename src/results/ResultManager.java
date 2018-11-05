package results;

import java.util.ArrayList;

import functionalityClasses.CRUDByID;
import functionalityClasses.CourseCRUDByID;
import util.DataBaseManager;
import util.DatabaseHandler;
import util.GradeCalculator;
import courses.*;

public class ResultManager {
	
	ArrayList<Result> results; 
	CRUDByID courseCRUD;
	
	
	public ResultManager() throws Exception {
		this.results = (ArrayList<Result>) DatabaseHandler.getResultData();
		courseCRUD = new CourseCRUDByID();
	}
	
	private Result buildResult(String courseID, String studentID) {
		courseCRUD = new CourseCRUDByID();
		Result results = new Result(courseID, studentID, "overall");
		results.addSubComponent(new ResultComponent("exam"));
		results.addSubComponent(new ResultComponent("coursework"));
		results.getSubComponent().get(1).addSubComponent(new ResultComponent("assignment"));
		results.getSubComponent().get(1).addSubComponent(new ResultComponent("class participation"));
		return results;
		
	}
	
	public void addResult(String courseID, String studentID) throws Exception {
		ResultManager rm = new ResultManager();
		Result result = rm.buildResult(courseID, studentID); 
		this.results.add(result);
		
		DatabaseHandler.updateResultData(this.results);
	}
	
	//Option: 1:exam, 2:assignment, 3: class part
	public void updateResult(String courseID, String studentID, double mark, int option) throws Exception{
		int index = getResultIndex(courseID, studentID);
		if(option >3 | option < 1) {
			throw new IllegalArgumentException("Option parameter can only be 1, 2 or 3.");
		}
		switch(option) {
		case 1:
			setEXResult(index, mark);
			break;
		case 2:	//first .get(1) returns coursework arraylist
			setASResult(index, mark);
			break;
		case 3:
			setCPResult(index, mark);
			break;
		}
		updateAllResult(courseID, studentID);
		
		DatabaseHandler.updateResultData(this.results);
		System.out.println("Result updated");
	}
	
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
	
	public void printCourseStatistics(String courseID) throws Exception{
		
		Course course = (Course) courseCRUD.readByID(courseID);
		double sum = 0;
		double highest =0; 
		double lowest = 100; 
		int count = 0;
		for(Result result : this.results) {
			if(result.getCourseID().equals(courseID)) {
				sum += result.getMark();
				if(result.getMark()>highest)
					highest = result.getMark(); 
				if(result.getMark()< lowest ) {
					lowest = result.getMark();
				}
				count++;
			}
		}
		
		System.out.println("----- Course Statistics ------"
				+ "\nCourse Name " + course.getCourseName() 
				+ "\nCourse ID: " + courseID
				+ "\nNumber of students: " + count
				+ "\nAverage Score: " + sum/count
				+ "\n Highest Score: "+  highest
				+ "\n Lowest Score:"+ lowest);
	}
	
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
	
	//Getter
	private double getASResult(Result result) {
		return result.getSubComponent().get(1).getSubComponent().get(0).getMark();
	}
	
	private double getCPResult(Result result) {
		return result.getSubComponent().get(1).getSubComponent().get(1).getMark();
	}
	
	private double getCWResult(Result result) {
		return result.getSubComponent().get(1).getMark();
	}
	
	private double getEXResult(Result result) {
		return result.getSubComponent().get(0).getMark();
	}
	
	private double getOverallResult(Result result) {
		return result.getMark();
	}
	
	private int getResultIndex(String courseID, String studentID) {
		for(Result result : this.results) {
			if(result.getCourseID().equals(courseID) && result.getStudentID().equals(studentID)) {
				return this.results.indexOf(result);
			}
		}
		return -1;
	}
	
	//Setter
	private void setASResult(int index, double mark) {
		this.results.get(index).getSubComponent().get(1).getSubComponent().get(0).setMark(mark);
	}
	
	private void setCPResult(int index, double mark) {
		this.results.get(index).getSubComponent().get(1).getSubComponent().get(1).setMark(mark);
	}
	
	private void setCWResult(int index, double mark) {
		this.results.get(index).getSubComponent().get(1).setMark(mark);
	}
	
	private void setEXResult(int index, double mark) {
		this.results.get(index).getSubComponent().get(0).setMark(mark);
	}
	
	private void setOverallResult(int index, double mark) {
		this.results.get(index).setMark(mark);
	}	
}
