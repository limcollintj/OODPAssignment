package students;
import java.util.*;
import courses.Course;
import courses.CourseManager;
import util.DataBaseManager;

public class StudentManager{
    private static final String STUDENT_FILENAME = "Students.txt";

    // Adds a new student to the data base
    public void addNewStudent(String name, String matricNum) {
    	//Do check to see if student already exist
        Student student = new Student(name, matricNum);
        ArrayList<Student> temp = retrieveStudents();
        temp.add(student);
        updateStudentDatabase(temp);
        System.out.println("Student has been added.");
    }

    
    // Finds a student according to his studentID
    public static Student getStudent(String studentID) throws Exception {
    		 for (Student temp : retrieveStudents() ) {
    	        	
    	            if(temp.getStudentID().equals(studentID)) {
    	                return temp;
    	            }
    	        }
        throw new Exception("This student cannot be found");
       
    }

    
    // Registers a student to the course
    public void registerCourse(String studentId, Course course) throws Exception{
    	ArrayList<Student> temp = retrieveStudents(); 
    	for(Student stud : temp) {
    		if(stud.getStudentID().equals(studentId)) {
    			stud.addCourse(course);	
    		}
    	}
    	
    	updateStudentDatabase(temp);
    	
    }


    
    
    // Prints out information about students
    
    // Prints out the whole list of students in the school
   

    
    // Prints out the courses a student has registered in 
    public void printCoursesRegistered(String studentID) {
    	Student student;    	
		try {
			student = getStudent(studentID);
			for(String courseID : student.getCourseIDs()) {
	    		CourseManager.getCourse(courseID).printCourseInfo();
	        	System.out.println(studentID + " has registered in ");
	    	}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
    	
    	
    }
    
    // Prints out all the students and its course information 
    public void printStudents() throws Exception{
        for(Student temp : retrieveStudents()) {
            System.out.println("Name: " + temp.getName()+ "\nStudentID: "+ temp.getStudentID() + "\n");
            for(String courseID : temp.getCourseIDs()) {
            	CourseManager.getCourse(courseID).printCourseInfo();
            }
        }
    }
    
    // Writes the arraylist to the student database
    // Database managers

    // Writes the object into the database
    public void updateStudentDatabase(Object obj){
        DataBaseManager.updateData(obj,STUDENT_FILENAME);
    }


    // Retrieves data from database
    public static ArrayList<Student> retrieveStudents() {

        if((ArrayList<Student>) DataBaseManager.retrieveData(STUDENT_FILENAME) == null) {
            ArrayList<Student> students = new ArrayList<Student>();
            DataBaseManager.updateData(students, STUDENT_FILENAME);
            return students;
        }
        else {
            return (ArrayList<Student>) DataBaseManager.retrieveData(STUDENT_FILENAME);
        }
    }
    
    // Resets the students database
    public void resetStudents() {
    	updateStudentDatabase(new ArrayList<Student>());
    }
}
