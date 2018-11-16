package functionalityClasses;

import java.util.ArrayList;

import courses.Course;
import students.Student;
import util.DatabaseHandler;

/**
 * <code>StudentUpdate</code> holds the name update and course registration methods
 * of the <code>Student</code> class
 * 
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class StudentUpdate {
	public void addName(String id, String name) throws Exception {
		ArrayList<Student> studentList = (ArrayList<Student>)DatabaseHandler.getStudentData();
		for(Student student : studentList) {	//Iterates through the studentList to find the student
			if(student.getStudentID().equals(id)) {
				student.setName(name);	//Update name of student
				DatabaseHandler.updateStudentData(studentList); //Update to database
				break;	//Break when Student is found
			}
		}
	}
	
	/**
	 * Registers the <code>Student</code> in the <code>Course</code>
	 * 
	 * @param course <code>Course</code> object
	 * @param studentId	ID of the desired <code>Student</code> object
	 * @throws Exception
	 */
	public void registerCourse(Course course, String studentId) throws Exception {
    	ArrayList<Student> students = (ArrayList<Student>) DatabaseHandler.getStudentData();
    	for(Student stud : students) {	//Iterate through the student container
    		if(stud.getStudentID().equals(studentId)) {
    			stud.addCourse(course);		//Add course id to specific student
    		}
    	}
    	DatabaseHandler.updateStudentData(students);	//Update to database
	}
} 
