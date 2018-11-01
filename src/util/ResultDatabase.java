package util;

import results.*;
import java.util.List;

public class ResultDatabase implements Database {
	private final String RESULT_FILENAME = "Results.txt";
	
	@Override
	public List<Result> getData() throws Exception{
		Object temp = DataBaseManager.retrieveData(this.RESULT_FILENAME);
        if(!(temp instanceof List)) {
        	throw new Exception("Object is not of List type.");
        } 
        List<Object> list = (List) temp;
        if(!list.isEmpty() && !(list.get(0) instanceof Result)) {
        	throw new Exception("Data is not of Result type");
        }
        return (List<Result>) temp;
	}
	
	@Override
	public void updateData(Object object) throws Exception{
		if(!(object instanceof List)) {
			throw new Exception("Object is not of List type.");
		}
		List<Object> list= (List) object;
		if(!list.isEmpty() && !(list.get(0) instanceof Result)) {
			throw new Exception("Data stored in container must be of Result type");
		}
		DataBaseManager.updateData(object, this.RESULT_FILENAME);
	}	
}
