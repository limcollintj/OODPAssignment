import java.util.*;

public class Course {
	private ArrayList<Student> registeredStudents;
	private String courseId;
	
	
	Course(String courseId){
		this.courseId = courseId;
		this.registeredStudents = new ArrayList<Student>();
	}
	
	Course(String courseId, ArrayList<Student> registeredStudents){
		this.registeredStudents = registeredStudents;
		this.courseId = courseId;
	}
	
	public ArrayList<Student> getRegisteredStudents(){
		return this.registeredStudents;
	}
	
	public void registerStudent(Student student) {
		if() {
			
		}
		registeredStudents.add(student);
	}
	
	private boolean checkStudentRegistered(Student student) {
		for(Student registeredStudent : registeredStudents) {
			if(registeredStudent.getStudentID() == student.getStudentID()) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
