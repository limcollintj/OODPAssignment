package functionalityClasses;

import courses.CourseManager;
import students.Student;

public class FindStudentByID implements FindByID{

	@Override
	public Student getByID(String id) throws Exception {
		
		
		
		return null;
	}

	
	@Override
	public void printByID(String id) throws Exception {
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


	
}
