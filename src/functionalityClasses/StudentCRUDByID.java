package functionalityClasses;

import students.Student;

import java.util.ArrayList;

import courses.Course;
import util.DatabaseHandler;

public class StudentCRUDByID implements CRUDByID{
	

	@Override
	public void createByID(String id) throws Exception{
	ArrayList<Student> students = (ArrayList<Student>) DatabaseHandler.getStudentData();
//		if(this.readByID(id) == null) {
//			//Do check to see if student already exist
//			
			
	        Student student = new Student(id);
	        
	        students.add(student);
	        DatabaseHandler.updateStudentData(students);
	        System.out.println("Student has been added.");
//		}else {
//			throw new Exception("Already exists");
//		}
	}
	
	@Override
	public Student readByID(String id) throws Exception{
		
		for (Student temp : DatabaseHandler.getStudentData() ) {
            if(temp.getStudentID().equals(id)) {
                return temp;
            }
        }
	   
        throw new Exception("This course cannot be found");
		
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
