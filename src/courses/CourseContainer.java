package courses;

import java.util.ArrayList;
import java.util.List;

import util.Container;

public class CourseContainer extends Container{
	@Override
	public Course findObjectByID(String id) {
		for(Object o : this.objects) {
			Course course = (Course)o;
			if(course.getCourseID().equals(id)) {
				return course;
			}
		}
		return null;
	}

	@Override
	public List<Object> findAllByID(String id) {
		List<Object> courses = new ArrayList<Object>();
		for(Object o : this.objects) {
			Course course = (Course)o;
			if(course.getCourseID().equals(id)) {
				courses.add(course);
			}
		}
		return courses;
	}
	
	@Override
	public void printAll() {
		System.out.println("----- Courses -----");
		for(Object o : this.objects) {
			Course course = (Course)o;
			System.out.println(course.getCourseID() + ": " + course.getCourseName());
		}
	}
}
