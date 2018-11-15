package functionalityClasses;

import java.util.List;

import util.Container;

public class findByID {
	public Object findObjectByID(Container container, String id){
		return container.findObjectByID(id);
	}
	
	public List<Object> findAllByID(Container container, String id){
		return container.findAllByID(id);
	}
}
