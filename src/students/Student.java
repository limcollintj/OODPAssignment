package students;
import java.io.Serializable;
import java.util.*;

import courses.Course;

/**
 * Represents a student enrolled in the school.
 * A student can be enrolled in many courses.
 *
 * @author LFM
 */

public class Student implements Serializable{

    /**
     * The name of the student
     */
    private String name;
    /**
     * The ID of the student
     */
    private String studentID;
    /**
     * A list of courses that the student has registered for
     */
    private ArrayList<String> courseIDs;

    /**
     * Creates a new student with the given name and ID
     * @param studentID This student's ID
     */
    public Student(String name, String studentID){
        this.name = name;
        this.studentID = studentID;
        this.courseIDs = new ArrayList<String>();
    }


    // getters:

    /**
     * Gets the name of the student
     * @return this student's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the ID of the student
     * @return this student's ID
     */
    public String getStudentID() {
        return this.studentID;
    }

    /**
     * Gets the course IDs of the courses that the student is registered for
     * @return A list of course IDs of courses that the student is registered for
     */
    public ArrayList<String> getCourseIDs() {
    	return this.courseIDs;
    }
    
    
    // Setters:

    /**
     * Enter the name of this student
     * @param name This student's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Enter the ID of this student
     * @param studentID This student's ID
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Registers student for a course
     * @param course course that the student want to register for
     * @throws Exception
     */
    public void addCourse(Course course) throws Exception{
    	if(this.registeredCourse(course)) {
    		throw new Exception("Student Already Registered For Course"); //TODO: Create specific exception
    	}
        this.courseIDs.add(course.getCourseID());
    }
    
    //Check if student already registered for course
    private boolean registeredCourse(Course course) {
    	return courseIDs.contains(course.getCourseID());
    }
    
    // Print information

    /**
     * Prints out the student's particulars, including name and ID
     */
    public void printInfo() {
    	System.out.println("Name: "+ name + ", StudentID: "+ studentID );
    }

}
