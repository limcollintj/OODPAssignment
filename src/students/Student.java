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

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    
    
    // Print information 
    public void printInfo() {
    	System.out.println("Name: "+ name + ", StudentID: "+ studentID );
    }

}
