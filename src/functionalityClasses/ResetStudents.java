package functionalityClasses;

import java.util.ArrayList;

import students.Student;
import util.DatabaseHandler;
/**
 * Clears all <code>Student</code> objects within the course database.
 * 
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class ResetStudents implements Reset{

	/**
	 * Reset the database of <code>Student</code> objects
	 */
	@Override
	public void reset() throws Exception {
		DatabaseHandler.updateStudentData(new ArrayList<Student>());
	}
	
	/**
	 * Iterates through all the <code>Student</code> objects and prints the specified information
	 */
	@Override
	public void printAll() throws Exception {
		for (Student student : DatabaseHandler.getStudentData()) {
			student.printInfo();
		}
	}
}
