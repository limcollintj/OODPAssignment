package functionalityClasses;

import students.Student;

import java.util.ArrayList;

import Exceptions.AlreadyExistsException;
import Exceptions.EntityNotFoundException;
import courses.Course;
import util.DatabaseHandler;


/**
 * Class for creating, reading, updating and deleting of courses by ID.
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class StudentCRUDByID implements CRUDByID{
	
	/**
	 * Create student by ID
	 * 
	 * @param id
	 * @throws AlreadyExistsException if the <code>Student</code> object already exists
	 * @throws Exception
	 */
	@Override
	public void createByID(String id) throws Exception{
	ArrayList<Student> students = (ArrayList<Student>) DatabaseHandler.getStudentData();
		if(this.readByID(id) == null) { //Check to see if student already exist
	        Student student = new Student(id);
	        students.add(student);
	        DatabaseHandler.updateStudentData(students);
		}else {
			 throw new AlreadyExistsException("Student");
		}
	}
	
	/**
	 * Read student by ID
	 * 
	 * @param id ID of desired <code>Student</code> object 
	 * @return Desired <code>Student</code> object corresponding to id
	 * @throws Exception
	 */
	@Override
	public Student readByID(String id) throws Exception {
		for (Student temp : DatabaseHandler.getStudentData() ) {
            if(temp.getStudentID().equals(id)) {
                return temp;
            }
		}
      return null;	//Returns null if Student is not found
	}
	/**
	 * Update <code>Student</code> object by ID
	 * 
	 * @param id of the desired <code>Student</code>
	 * @throws EntityNotFoundException thrown when the student with the specified ID is not found
	 * @throws Exception
	 */
	
	@Override
	public void updateByID(String id, Object o) throws Exception {
		Student student = this.readByID(id);
		ArrayList<Student> studentList = (ArrayList<Student>)DatabaseHandler.getStudentData();
		int studentIndex = studentList.indexOf(student);	//Returns -1 if student object not found
		if(o instanceof Student && studentIndex != -1) {	//Checks if o is of Student type
			studentList.set(studentIndex, (Student)o);
			DatabaseHandler.updateStudentData(studentList);
		} else { //Throws exception if entity not found
			throw new EntityNotFoundException();
		}
	}
	
	/**
	 * Delete <code>Student</code> by ID
	 * @param id
	 * @throws EntityNotFoundException
	 * @throws Exception
	 */
	@Override
	public void deleteByID(String id) throws Exception {
		ArrayList<Student> studentList = (ArrayList<Student>)DatabaseHandler.getStudentData();
		for(Student student : studentList) {
			if(student.getStudentID().equals(id)) {
				studentList.remove(student);
				DatabaseHandler.updateStudentData(studentList);
				break;	//Break when the student is found and deleted
			} else {	//Throws an exception if object is not found
				throw new EntityNotFoundException();
			}
		}
	}
	
	
}
