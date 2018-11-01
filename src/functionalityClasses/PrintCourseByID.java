package functionalityClasses;

import courses.Course;
import students.Student;
import students.StudentManager;
import util.DatabaseHandler;

public class PrintCourseByID implements PrintByID{


	@Override
	public void printByID(String id) throws Exception {
		
		Course temp = new CourseCRUDByID().readByID(id);
		CRUDByID crudID = new StudentCRUDByID();
		
    	for (String studentID : temp.getregisteredStudentIDs()) {
    		Student stud = (Student) crudID.readByID(studentID);
    		stud.printInfo();
		
	}

	

}

}