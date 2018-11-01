package functionalityClasses;

import courses.Course;

public interface CRUDByID {
	void createByID(String id) throws Exception;
	Object readByID(String id) throws Exception;
	void updateByID(String id) throws Exception;
	void deleteByID(String id) throws Exception;
}
