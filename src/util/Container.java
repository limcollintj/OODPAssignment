package util;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import functionalityClasses.PrintAll;


public abstract class Container implements Findable, Exists, PrintAll, Serializable{
	protected List<Object> objects = new ArrayList<Object>();
	
	public List<Object> getObjects(){
		return this.objects;
	}
	
	public boolean exists(String id) {
		boolean exist;
		if(this.findObjectByID(id).equals(null)) {
			exist = true;
		} else {
			exist = false;
		}
		return exist;
	}
	
}
