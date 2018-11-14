package functionalityClasses;

import java.util.ArrayList;

import courses.Course;
import students.Student;
import util.DatabaseHandler;

public class ResetStudents implements Reset{

	@Override
	public void reset() throws Exception {
		DatabaseHandler.updateStudentData(new ArrayList<Student>());
	}
	
	@Override
	public void printAll() throws Exception {
		
		for (Student student : DatabaseHandler.getStudentData()) {
			student.printInfo();
		}
		
	}

}
