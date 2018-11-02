package lessons;

import java.util.ArrayList;
import util.DatabaseHandler;
import courses.Course;
import functionalityClasses.CRUDByID;
import functionalityClasses.CourseCRUDByID;

public class LessonManager {
	
	
	
	
	// Adds new lesson to course 
	// Updates ArrayList<Lesson> in Course 
	public void addLesson(String courseID, int option, String lessonID, int vacancy) throws Exception{
		ArrayList<Course> courses = (ArrayList<Course>)DatabaseHandler.getCourseData();
	
		for(Course course : courses) {
			if(course.getCourseID().equals(courseID)) {
				if(!this.checkIdLessonAdded(courseID, lessonID)) {
					switch(option) {
					case 1:
						Lessons lecture = new Lecture(lessonID, vacancy);
						course.addLesson(lecture);
						break;
					case 2:
						Lessons lab = new Lab(lessonID, vacancy);
						course.addLesson(lab);
						break;
					case 3:
						Lessons tutorial = new Tutorial(lessonID, vacancy);
						course.addLesson(tutorial);
						break;
					}
				}
				else {
					throw new Exception("Lesson has already been added\n");
				}
				
			}
		}
		DatabaseHandler.updateCourseData(courses);
	}
	
	private boolean checkIdLessonAdded(String courseID, String lessonID) throws Exception {
		ArrayList<Course> courses = (ArrayList<Course>)DatabaseHandler.getCourseData();
		
		for(Course course : courses) {
			if(course.getCourseID().equals(courseID)) {
				for(Lessons lesson : course.getLessons()) {
					if(lesson.getLessonID().equals(lessonID)) {
						return true;
					}
				}
			}
		}
		return false;
			
	}
	
	
	//Prints lesson in a course
	public void printAllLesson(String id) throws Exception {
		CRUDByID cID = new CourseCRUDByID();
		
		 Course temp = (Course) cID.readByID(id);
				 
			for(Lessons lesson : temp.getLessons()) {
	    		lesson.printInfo();
	    	}
	}
	
	public void printLesson(String courseID, String lessonID) throws Exception {
		CRUDByID cID = new CourseCRUDByID();
		
		 Course temp = (Course) cID.readByID(courseID);
				 
			for(Lessons lesson : temp.getLessons()) {
				if(lesson.getLessonID().equals(lessonID))
	    		lesson.printInfo();
	    	}
	}


	public void addStudentToLesson(String studentID, String courseID, String lessonID) throws Exception {
		ArrayList<Course> courses = (ArrayList<Course>) DatabaseHandler.getCourseData(); 
		
		for(Course course : courses) {
			if(course.getCourseID().equals(courseID) ) {
				for (Lessons lesson : course.getLessons()) {
					if(lesson.getLessonID().equals(lessonID)) {
						if(!studentInCourse(course, studentID)) {
							throw new Exception("Student not in course");
						}
						lesson.addStudent(studentID);
					}
				}
			}}
		
		DatabaseHandler.updateCourseData(courses);
		
	}
	
	private boolean studentInCourse(Course course, String studentID) {
		return course.getregisteredStudentIDs().contains(studentID);
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
