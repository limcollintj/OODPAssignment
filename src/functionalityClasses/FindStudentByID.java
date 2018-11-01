package functionalityClasses;

import courses.Course;
import courses.CourseManager;
import students.Student;
import util.DatabaseHandler;

public class FindStudentByID implements FindByID{

	@Override
	public Student getByID(String id) throws Exception {
		
		for (Student temp : DatabaseHandler.getStudentData() ) {
            if(temp.getStudentID().equals(id)) {
                return temp;
            }
        }
	   
        throw new Exception("This course cannot be found");
	}

	
	@Override
	public void printByID(String id) throws Exception {
		Student student;    	
		
			student = this.getByID(id);
			for(String courseID : student.getCourseIDs()) {
	    		new FindCourseByID().getByID(courseID).printCourseInfo();
	        	System.out.println(id + " has registered in ");
			}
			
	}


	
}
