package functionalityClasses;

import util.Container;

public class AddToContainer {
	public void add(Container container, Object o) {
		container.getObjects().add(o);
	}
	
}
