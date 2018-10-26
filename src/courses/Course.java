package courses;
import java.io.Serializable;
import java.util.*;

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
    private final int maxVacancy;
    private int vacancy;
    boolean haveSubComponents;
    int exWeightage, cwWeightage, asWeightage, cpWeightage;
    ArrayList<String> registeredStudentIDs;
    ArrayList<Lessons> lessons;
    ArrayList<String> profNames;
    
    
    Course(String ID, int maxVacancy) {

        this.courseID = ID;
        this.profNames = new ArrayList<String>();
        this.maxVacancy = maxVacancy;
        this.courseName = "Unknown Course";
        this.haveSubComponents = false;
        this.exWeightage = this.cwWeightage = this.asWeightage = this.cpWeightage = 0;
        this.lessons = new ArrayList<Lessons>();
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
    
    public ArrayList<String> getRegisteredStudents(){
		return this.registeredStudentIDs;
	}
    
    public void addStudent(String studentID) throws Exception{
		if(this.checkStudentRegistered(studentID)) {
			throw new Exception();	//TODO:Create new specific exception class
		}
		registeredStudentIDs.add(studentID);
	}
    
    public ArrayList<Lessons> getLessons(){
    	return this.lessons;
    }
    
    public void addLessons(Lessons lesson) {
    	this.lessons.add(lesson);
    }
    
    private boolean validWeightage(){
    	return (this.exWeightage + this.cwWeightage + this.asWeightage + this.cpWeightage) == 100;
    }
    
    private boolean checkStudentRegistered(String studentID) {
		return registeredStudentIDs.contains(studentID);
	}
    
    
}