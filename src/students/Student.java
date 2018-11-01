package students;
import java.io.Serializable;
import java.util.*;

import courses.Course;

public class Student implements Serializable{

    private String name, studentID;
    private ArrayList<String> courseIDs;
    
    
    public Student(String studentID){
        this.name = name;
        this.studentID = studentID;
        this.courseIDs = new ArrayList<String>();
    }


    // getters:
    public String getName() {
        return this.name;
    }

    public String getStudentID() {
        return this.studentID;
    }

    
    public ArrayList<String> getCourseIDs() {
    	return this.courseIDs;
    }
    
    
    // Setters:
    public void setName(String name) {
        this.name = name;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void addCourse(Course course) throws Exception{
    	if(this.registeredCourse(course)) {
    		throw new Exception("Student Already Registered For Course"); //TODO: Create specfic exception
    	}
        this.courseIDs.add(course.getCourseID());
    }
    
    //Check if student already registered for course
    private boolean registeredCourse(Course course) {
    	
    	return courseIDs.contains(course.getCourseID());
    }
    
    // Print information 
    public void printInfo() {
    	System.out.println("Name: "+ name + ", StudentID: "+ studentID );
    }

}
