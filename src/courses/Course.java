package courses;
import java.io.Serializable;

import java.util.*;

import lessons.Lessons;
import students.Student;

/**
 * <code>Course</code> is a serializable entity class representing each course in a school.
 * @author  LFM
 * @version 1.0
 * @since   2018-11-05
 */
public class Course implements Serializable {

    /**
     * The ID of this course, which is unique to each course.
     */
    private final String courseID;

    /**
     * The name of this course.
     */
    private String courseName;

    /**
     * The maximum number of students that can be registered for this course.
     */
    private int maxVacancy;

    /**
     * The current number of students registered for this course.
     */
    private int vacancy;

    /**
     * Indication of whether this course has Coursework subcomponents.
     */
    boolean haveSubComponents;

    /**
     * The exam weightage, course work weightage, assignment weightage and class participation weightage of this course respectively.
     * The sum of exam and coursework weightages must be equal to 100.
     * If this course has subcomponents, the sum of the assignment and class participation weightage must be equal to 100
     */
    private int exWeightage, cwWeightage, asWeightage, cpWeightage;

    /**
     * The <code>ArrayList</code> containing unique Student IDs of students registered for this course.
     */
    private ArrayList<String> registeredStudentIDs;

    /**
     * The <code>ArrayList</code> containing Lesson objects which are Lab/tutorial/Lecture objects belonging to this course.
     */
    private ArrayList<Lessons> lessons;

    /**
     *  The <code>ArrayList</code> containing the names of the professors who teach this course.
     *  The first professor in this <code>ArrayList</code> is this course coordinator
     */
    private ArrayList<String> profNames;


    /**
     * Creates a new Course with the given id.
     * The id should be unique.
     * @param ID This Course's ID.
     */
    public Course(String ID){
    	this.courseID = ID;
    	this.maxVacancy = this.vacancy = 0;
    	this.courseName = "Unknown Course";
        this.haveSubComponents = false;
        this.exWeightage = 100;
        this.cwWeightage = this.asWeightage = this.cpWeightage = 0;
        this.lessons = new ArrayList<Lessons>();
        this.registeredStudentIDs = new ArrayList<String>();
        this.profNames = new ArrayList<String>();
    }

    /**
     * Creates a new Course with the given id and given maximum vacancy.
     * The id should be unique.
     * @param ID This Course's ID
     * @param vacancy The maximum vacancy for this Course.
     */
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
    
    Course(String name, String ID, ){
    	
    }

    /**
     * Gets the ID of this Course
     * @return This Course's ID
     */
    public String getCourseID() {
        return this.courseID;
    }

    /**
     * Gets the name for this Course.
     * @return This Course's name.
     */
    public String getCourseName() {
    	return this.courseName;
    }

    /**
     * Changes the name for this Course.
     * @param courseName This Course's new name.
     */
    public void setCourseName(String courseName) {
    	this.courseName = courseName;
    }

    /**
     * Get the ArrayList of professor names teaching this Course.
     * @return <code>ArrayList</code> of professor names.
     */
    public ArrayList<String> getProfNames() {
        return this.profNames;
    }

    /**
     * Adds another professor who is teaching this Course to the <code>ArrayList</code> of professor names.
     * @param profName The professor's name.
     */
    public void addProfName(String profName) {
    	this.profNames.add(profName);
    }

    /**
     * Get the maximum number of students that can register for this Course.
     * @return This Course's maximum vacancy.
     */
    public int getMaxVacancy() {
    	return this.maxVacancy;
    }

    /**
     * Get the remaining number of students who can register for this Course.
     * @return This Course's current vacancy.
     */
    public int getVacancy() {
    	return this.vacancy;
    }

    /**
     * Changes the maximum number of students who can register for this Course.
     * @param maxVacancy This Course's new maximum vacancy.
     */
    public void setMaxVacancy(int maxVacancy) {
    	int increase = maxVacancy - this.maxVacancy;
    	this.maxVacancy = maxVacancy;
    	this.vacancy += increase;
    }

    /**
     * Gets the ArrayList contaning the IDs of the students who are registered for this Course.
     * @return <code>ArrayList</code> of the IDs of the students registered for this course.
     */
    public ArrayList<String> getregisteredStudentIDs(){
		return this.registeredStudentIDs;
	}


    /**
     * Adds a registered student's ID to the ArrayList of registered student ID's of this Course.
     * @param student Registered Student object
     * @throws Exception
     */
    public void addStudent(Student student) throws Exception{
		if(this.studentRegistered(student)) {
			throw new Exception();	//TODO:Create new specific exception class
		}
		registeredStudentIDs.add(student.getStudentID());
	}

    /**
     * Gets the ArrayList containing Lesson objects (Tutorials/Labs/Lectures) belonging to this Course.
     * @return <code>ArrayList</code> of Lesson objects
     */
    public ArrayList<Lessons> getLessons(){
    	return this.lessons;
    }

    /**
     * Adds a Lesson object (Tutorial/Lab/Lecture) to the ArrayList of Lesson objects of this Course.
     * @param lesson Lesson object belonging to this Course.
     */
    public void addLesson(Lessons lesson) {
    	this.lessons.add(lesson);
    }

    /**
     * Checks if the sum of this Course's exam weightage and coursework weightage adds up to 100.
     * Checks if the sum of this Course's assesment weightage and coursework weightage adds up to 100
     * @return true if both sum adds up and false if either one/both sums dont add up
     */
    private boolean validWeightage(){
    	return (this.exWeightage + this.cwWeightage == 100) && (this.asWeightage + this.cpWeightage == 100);
    }

    /**
     * Checks if a student has registered for this Course.
     * @param student Student object which needs to be checked
     * @return true if Student has registered for this Course or false if otherwise
     */
    private boolean studentRegistered(Student student) {
		return registeredStudentIDs.contains(student.getStudentID());
	}

    /**
     * Gets the exam weightage of this Course.
     * @return this Course's exam weightage.
     */
    public int getEXWeightage() {	
    	return this.exWeightage;	//exam
    }

    /**
     * Set the exam weightage of this Course.
     * @param exWeightage this Course's new exam weightage.
     */
    public void setEXWeightage(int exWeightage) {
    	this.exWeightage = exWeightage;
    }

    /**
     * Gets the coursework weightage of this Course.
     * @return this Course's coursework weightage.
     */
    public int getCWWeightage() {
    	return this.cwWeightage;	//coursework
    }

    /**
     * Set the coursework weightage of this Course.
     * @param cwWeightage this Course's new coursework weightage.
     */
    public void setCWWeightage(int cwWeightage) {
    	this.cwWeightage = cwWeightage;
    }

    /**
     * Gets the assessment weightage of this Course.
     * @return this Course's assessment weightage.
     */
    public int getASWeightage() {
    	return this.asWeightage;	//assignment
    }

    /**
     * Set the assignment weightage of this Course.
     * @param asWeightage this Course's new assignment weightage.
     */
    public void setASWeightage(int asWeightage) {
    	this.asWeightage = asWeightage;
    }

    /**
     * Gets the class participation weightage of this Course.
     * @return this Course's class participation weightage.
     */
    public int getCPWeightage() {
    	return this.cpWeightage;	//class participation
    }

    /**
     * Set the class participation weightage of this Course.
     * @param cpWeightage this Course's new class participation weightage.
     */
    public void setCPWeightage(int cpWeightage) {
    	this.cpWeightage = cpWeightage;
    }

    /**
     * Prints the Course Information of this Course.
     * Course Information contains this Course's ID, vacancy number, Coordinator's name and Professor's name.
     */
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

    /**
     * Reduces the vacancy number of this Course by 1 whenever a Student has registered for this Course.
     * @throws Exception If vacancy number is 0 or less.
     */
    public void reduceVacancy() throws Exception {
    	if(this.vacancy <= 0) {
    		throw new Exception("No more Vacancies");
    	}
    	this.vacancy -= 1;
    }
    
}
