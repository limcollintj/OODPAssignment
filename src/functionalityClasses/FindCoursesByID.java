package functionalityClasses;

import courses.Course;
import students.StudentManager;
import util.DatabaseHandler;

public class FindCoursesByID implements FindByID{

	@Override
	public Course getByID(String id) throws Exception {
		 
		for (Course temp : DatabaseHandler.getCourseData() ) {
	            if(temp.getCourseID().equals(id)) {
	                return temp;
	            }
	        }
		   
	        throw new Exception("This course cannot be found");
		
	}

	@Override
	public void printByID(String id) throws Exception {
		
		Course temp = this.getByID(id); 
    	for (String studentID : temp.getregisteredStudentIDs()) {
    		StudentManager.getStudent(studentID).printInfo();
    	}
		
	}

}
