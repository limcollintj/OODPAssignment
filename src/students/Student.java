package students;
import java.io.Serializable;
import java.util.*;

import courses.Course;

public class Student implements Serializable{

    private String name, studentID;
    public ArrayList<Course> courses;
    
    
    Student(String name, String studentID){
        this.name = name;
        this.studentID = studentID;
        this.courses = new ArrayList<Course>();
    }


    // getters:
    public String getName() {
        return name;
    }

    public String getStudentID() {
        return studentID;
    }

    
    public ArrayList<Course> getCourses() {
    	return courses;
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
    		throw new Exception(); //TODO: Create specfic exception
    	}
        this.courses.add(course);
    }
    
    //Check if student already registered for course
    private boolean registeredCourse(Course course) {
    	return courses.contains(course);
    }
    
    // Print information 
    public void printInfo() {
    	System.out.println("Name: "+ name + ", StudentID: "+ studentID );
    }

}
