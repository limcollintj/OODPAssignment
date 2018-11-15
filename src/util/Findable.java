package util;

import java.util.List;

public interface Findable {
	public Object findObjectByID(String id);
	public List<Object> findAllByID(String id);
}
