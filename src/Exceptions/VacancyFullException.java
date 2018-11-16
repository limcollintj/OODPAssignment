package Exceptions;

/**
 * <code>Exception</code> class to be thrown when the vacancy in <code>Course</code> or 
 * <code>Lesson</code> is 0 or less. This <code>Exception</code> is specific to this 
 * project.
 * 
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class VacancyFullException extends Exception{
	/**
	 * Constructor of <code>VacancyFullException</code> class.
	 */
	public VacancyFullException() {
		super ("There are no more vacancies left");
	}
}
