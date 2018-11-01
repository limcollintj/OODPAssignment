package lessons;

import java.util.ArrayList;
import util.DatabaseHandler;
import courses.Course;
import functionalityClasses.CRUDByID;
import functionalityClasses.CourseCRUDByID;

public class LessonManager {
	
	
	
	
	// Adds new lesson to course 
	// Updates ArrayList<Lesson> in Course 
	public void addLesson(String courseID, int option, String lessonID) throws Exception{
		ArrayList<Course> courses = (ArrayList<Course>)DatabaseHandler.getCourseData();
		for(Course course : courses) {
			if(course.getCourseID().equals(courseID)) {
				switch(option) {
				case 1:
					Lessons lecture = new Lecture(lessonID);
					course.addLesson(lecture);
					break;
				case 2:
					Lessons lab = new Lab(lessonID);
					course.addLesson(lab);
					break;
				case 3:
					Lessons tutorial = new Tutorial(lessonID);
					course.addLesson(tutorial);
					break;
				}
			}
		}
	}
	
	//Prints lesson in a course
	public void printLesson(String id) throws Exception {
		CRUDByID cID = new CourseCRUDByID();
		
		 Course temp = (Course) cID.readByID(id);
				 
			for(Lessons lesson : temp.getLessons()) {
	    		lesson.printInfo();
	    	}
	}
	
//	 public void removeLessons(String lessonID) {
//		 CRUDByID cID = new CourseCRUDByID();
//		 Course temp = (Course) cID.readByID(id);
//		 
//	    	for(Lessons temp : lessons) {
//	    		if(temp.getLessonID() == lessonID) {
//	    			lessons.remove(temp);
//	    		}
//	    	}
//	    }
	
}
