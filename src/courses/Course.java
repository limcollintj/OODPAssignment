package courses;
import java.io.Serializable;
import java.util.*;

import students.Student;

public class Course implements Serializable {
	private ArrayList<Student> registeredStudents;
	private final String courseId;
    private int vacancy;
    
	Course(String courseId, int vacancy){
		this.courseId = courseId;
		this.vacancy = vacancy;
		this.registeredStudents = new ArrayList<Student>();
	}
	
	Course(String courseId, ArrayList<Student> registeredStudents){
		this.registeredStudents = registeredStudents;
		this.courseId = courseId;
	}
	
	public ArrayList<Student> getRegisteredStudents(){
		return this.registeredStudents;
	}
	
	public void addStudent(Student student) throws Exception{
		if(this.checkStudentRegistered(student)) {
			throw new Exception();	//TODO:Create new specific exception class
		}
		registeredStudents.add(student);
	}
	
	public boolean removeStudent(Student student){
		return registeredStudents.remove(student);
	}
	
	public String getCourseID() {
		return this.courseId;
	}
	
	public int getVacancy() {
		return this.vacancy;
	}
	
	private boolean checkStudentRegistered(Student student) {
		return registeredStudents.contains(student);
	}
}
