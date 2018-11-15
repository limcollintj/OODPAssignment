package students;

import java.util.List;
import java.util.ArrayList;

import util.Container;
import students.Student;

public class StudentContainer extends Container{
	
	@Override
	public Student findObjectByID(String id) {
		if(!this.objects.isEmpty()) {
			for(Object o : this.objects) {
				Student student = (Student)o;
				if(student.getStudentID().equals(id)) {
					return student;
				}
			}
		}
		return null;
	}

	@Override
	public List<Object> findAllByID(String id) {
		List<Object> students = new ArrayList<Object>();
		for(Object o : this.objects) {
			Student student = (Student)o;
			if(student.getStudentID().equals(id)) {
				students.add(student);
			}
		}
		return students;
	}
	
	@Override
	public void printAll() {
		System.out.println("----- Students -----");
		for(Object o : this.objects) {
			Student student = (Student)o;
			System.out.println(student.getStudentID() + ": " + student.getName());
		}
	}
	
	@Override
	public boolean exists(String id) {
		boolean exist;
		if(findObjectByID(id) != null) {
			exist = true;
		} else {
			exist = false;
		}
		return exist;
	}
	
	
}
