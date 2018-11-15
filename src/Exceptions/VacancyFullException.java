package Exceptions;

public class VacancyFullException extends Exception{
	public VacancyFullException() {
		super ("There are no more vacancies left");
	}
}
