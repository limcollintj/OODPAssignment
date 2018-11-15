package functionalityClasses;

import students.Student;

import java.util.ArrayList;

import Exceptions.AlreadyExistsException;
import Exceptions.EntityNotFoundException;
import courses.Course;
import util.DatabaseHandler;

public class StudentCRUDByID implements CRUDByID{
	

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
	
	@Override
	public Student readByID(String id) throws Exception {
		
		for (Student temp : DatabaseHandler.getStudentData() ) {
            if(temp.getStudentID().equals(id)) {
                return temp;
            }
        }
	   
      return null; 
		
	}
	
	@Override
	public void updateByID(String id) {
		//TODO: Determine all possible updates
	}
	
	@Override
	public void deleteByID(String id) throws Exception {
		
		ArrayList<Student> studentList = (ArrayList<Student>)DatabaseHandler.getStudentData();
		for(Student student : studentList) {
			if(student.getStudentID().equals(id)) {
				studentList.remove(student);
				DatabaseHandler.updateStudentData(studentList);
				break;
			}
		}
	}
	
	
}
