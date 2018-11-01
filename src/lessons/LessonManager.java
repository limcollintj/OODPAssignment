package lessons;

import java.util.ArrayList;
import util.DatabaseHandler;
import courses.Course;

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
}
