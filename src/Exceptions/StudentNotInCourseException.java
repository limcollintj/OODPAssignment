package Exceptions;

/**
 * <code>Exception</code> class to be thrown when a <code>Student</code> ID cannot be found
 * in the corresponding <code>Course</code>. This <code>Exception</code> is specific to 
 * the current project.
 * 
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class StudentNotInCourseException extends Exception {
	/**
	 * Constructor of <code>StudentNotInCourseException</code> class.
	 */
	public StudentNotInCourseException() {
		super("Student not In Course");
	}
}
