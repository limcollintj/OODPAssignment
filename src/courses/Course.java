package courses;
import java.io.Serializable;

import java.util.*;

import lessons.Lessons;
import students.Student;

import java.io.Serializable;

/**
 * <code>CourseInfo</code> is a serializable entity class. <code>CourseInfo</code> stores the following
 * information:
 * <ul>
 * <li> course ID
 * <li> Array of lecturer ID
 * <li> <code>ArrayList</code> of {@link Lessons} 
 * <li> Weightages of the respective {@link Results} of each component <code>Lesson</code>
 * </ul>
 * 
 * The course ID should be unique to ensure that no duplicates are created.
 * 
 * @author LFM
 */
public class Course implements Serializable {

    private final String courseID;
    private String courseName;
    private int maxVacancy;
    private int vacancy;
    boolean haveSubComponents;
    private int exWeightage, cwWeightage, asWeightage, cpWeightage;
    private ArrayList<String> registeredStudentIDs;
    private ArrayList<Lessons> lessons;
    private ArrayList<String> profNames;	// first prof is main prof
    
    public Course(String ID){
    	this.courseID = ID;
    	this.maxVacancy = this.vacancy = 0;
    	this.courseName = "Unknown Course";
        this.haveSubComponents = false;
        this.exWeightage = 100;
        this.cwWeightage = this.asWeightage = 0;
        this.cpWeightage = 0;
        this.lessons = new ArrayList<Lessons>();
        this.registeredStudentIDs = new ArrayList<String>();
        this.profNames = new ArrayList<String>();
    }
    
    Course(String ID, int vacancy) {

        this.courseID = ID;
        this.profNames = new ArrayList<String>();
        this.maxVacancy = this.vacancy = vacancy;
        this.courseName = "Unknown Course";
        this.haveSubComponents = false;
        this.exWeightage = 100;
        this.cwWeightage = this.asWeightage = 0;
        this.cpWeightage = 100;
        this.lessons = new ArrayList<Lessons>();
        this.registeredStudentIDs = new ArrayList<String>();
        this.profNames = new ArrayList<String>();
    }
    
    
    
    

    /**
     * Returns course ID of the <code>CourseInfo</code>
     * 
     * @return course ID
     */
    public String getCourseID() {
        return this.courseID;
    }
    
    public String getCourseName() {
    	return this.courseName;
    }
    
    public void setCourseName(String courseName) {
    	this.courseName = courseName;
    }
    /**
     * Return an array of names of lecturer-in-charge in no particular order.
     * 
     * @return <code>Array</code> of lecturer IDs
     */
    public ArrayList<String> getProfNames() {
        return this.profNames;
    }
    
    public void addProfName(String profName) {
    	this.profNames.add(profName);
    }
    
    public int getMaxVacancy() {
    	return this.maxVacancy;
    }
    
    public int getVacancy() {
    	return this.vacancy;
    }
    
    public void setMaxVacancy(int maxVacancy) {
    	int increase = maxVacancy - this.maxVacancy;
    	this.maxVacancy = maxVacancy;
    	this.vacancy += increase;
    }
    
    public ArrayList<String> getregisteredStudentIDs(){
		return this.registeredStudentIDs;
	}
    
        
    
    // adding student into course
    public void addStudent(Student student) throws Exception{
		if(this.studentRegistered(student)) {
			throw new Exception();	//TODO:Create new specific exception class
		}
		registeredStudentIDs.add(student.getStudentID());
	}
    
    public ArrayList<Lessons> getLessons(){
    	return this.lessons;
    }
    
    public void addLesson(Lessons lesson) {
    	this.lessons.add(lesson);
    }
    
    private boolean validWeightage(){
    	return (this.exWeightage + this.cwWeightage == 100) && (this.asWeightage + this.cpWeightage == 100);
    }
    
    private boolean studentRegistered(Student student) {
		return registeredStudentIDs.contains(student.getStudentID());
	}
    
    public int getEXWeightage() {	
    	return this.exWeightage;	//exam
    }
    
    public void setEXWeightage(int exWeightage) {
    	this.exWeightage = exWeightage;
    }
    
    public int getCWWeightage() {
    	return this.cwWeightage;	//coursework
    }
    
    public void setCWWeightage(int cwWeightage) {
    	this.cwWeightage = cwWeightage;
    }
    
    public int getASWeightage() {
    	return this.asWeightage;	//assignment
    }
    
    public void setASWeightage(int asWeightage) {
    	this.asWeightage = asWeightage;
    }
    
    public int getCPWeightage() {
    	return this.cpWeightage;	//class participation
    }
    
    public void setCPWeightage(int cpWeightage) {
    	this.cpWeightage = cpWeightage;
    }
    
    // printing course information 
    public void printCourseInfo() {
    	System.out.print("Course ID: "+ courseID + "," + "\nVacancy: "+ vacancy + ", "
    			+ "\nMain Professor: " + this.profNames.get(0)
    			+ "\nProfessor names: ");
    	
    		for(int i = 1; i < this.profNames.size(); i++) {
        		System.out.print(this.profNames.get(i) + ",");
        	}
    		if(!(this.profNames.size() < 2)) {
    			System.out.print("None");
    		}
    	System.out.print("\n");
    }
    
    // Reduces Vacancy 
    public void reduceVacancy() throws Exception {
    	if(this.vacancy <= 0) {
    		throw new Exception("No more Vacancies");
    	}
    	this.vacancy -= 1;
    }
    
}
