package students;
import java.util.*;
import courses.Course;
import courses.CourseManager;
import functionalityClasses.FindByID;
import functionalityClasses.FindStudentByID;
import functionalityClasses.Reset;
import functionalityClasses.ResetStudents;
import util.DataBaseManager;

public class StudentManager{
   
    private Reset reset;
    private FindByID fbID;

    public StudentManager() {
    	this.reset = new ResetStudents();
    	this.fbID = new FindStudentByID();
    	
    }
    
    // Adds a new student to the data base
    public void addNewStudent(String name, String matricNum) {
    	//Do check to see if student already exist
        Student student = new Student(name, matricNum);
        this.students.add(student);
        updateStudentDatabase(this.students);
        System.out.println("Student has been added.");
    }

    
    
    // Registers a student to the course
    public void registerCourse(String studentId, Course course) throws Exception{
    	//Do checks to see if student already registered
    	for(Student stud : this.students) {
    		if(stud.getStudentID().equals(studentId)) {
    			stud.addCourse(course);	
    		}
    	}
    	updateStudentDatabase(this.students);
    	
    }


    
  
    // Prints out the courses a student has registered in 
    public void printCoursesRegistered(String studentID) throws Exception {
    	fbID.printByID(studentID);
    }
    
    
    // Prints out all the students and its course information 
    public void printStudents() throws Exception{
        reset.printAll();
    }
  
    
    // Resets the students database
    public void resetStudents() throws Exception {
    	reset.reset();
    }
}
