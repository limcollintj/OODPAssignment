package Exceptions;

public class AlreadyRegisteredException extends Exception {

	public AlreadyRegisteredException(String type){
		super("Already registered in " + type);
	}
}
