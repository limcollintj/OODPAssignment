package Exceptions;

public class AlreadyExistsException extends Exception{
	public AlreadyExistsException(String type) {
		super(type + "Already Exists");
	}
}
