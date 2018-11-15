package lessons;

import java.awt.Container;
import java.util.ArrayList;
import util.DatabaseHandler;
import courses.Course;
import functionalityClasses.CRUDByID;
import functionalityClasses.CourseCRUDByID;

/**
 * <code>Lesson Manager</code> is a control class that handles the operations done to the <code>Lesson</code> entity class objects.
 * @author LFM
 * @version 1.0
 * @since 2018-11-07
 */
public class LessonManager {

    /**
     * Adds a Lesson object with a given vacancy to a given Course object.
     * The Lesson object can be of type lecture/tutorial/lab.
     * @param courseID the ID of the Course the Lesson object belongs to.
     * @param option the type of Lesson object to be created (1: lecture, 2: lab, 3: tutorial)
     * @param lessonID the ID of the Lesson object
     * @param vacancy the number of Students who can register for the Lesson.
     * @throws Exception
     */
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

    /**
     * Checks if a given Lesson object belongs to the <code>Course</code> ArrayList of Lessons.
     * @param courseID ID of the Course.
     * @param lessonID ID of the Lesson
     * @return true if the Lesson has been added to the ArrayList and false if otherwise.
     * @throws Exception
     */
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

    /**
     * Prints the all the Lesson information of a given Course object.
     * @param id ID of the Course.
     * @throws Exception
     */
	public void printAllLesson(String id) throws Exception {
		CRUDByID cID = new CourseCRUDByID();
		
		 Course temp = (Course) cID.readByID(id);
				 
			for(Lessons lesson : temp.getLessons()) {
	    		lesson.printInfo();
	    	}
	}

    /**
     * Prints the information of a given Lesson from a given Course.
     * @param courseID the ID of the Course
     * @param lessonID the ID of the Lesson
     * @throws Exception
     */
	public void printLesson(String courseID, String lessonID) throws Exception {
		CRUDByID cID = new CourseCRUDByID();
		
		 Course temp = (Course) cID.readByID(courseID);
				 
			for(Lessons lesson : temp.getLessons()) {
				if(lesson.getLessonID().equals(lessonID))
	    		lesson.printInfo();
	    	}
	}

    /**
     * Registers a given Student for a Lesson in a given Course
     * The Student should already be registered for the Course.
     * The Lesson should already be added to the Course.
     * @param studentID the ID of the Student
     * @param courseID the ID of the Course
     * @param lessonID the ID of the Lesson
     * @return true if the Student has been successfully registered and false if otherwise
     * @throws Exception
     */
	public boolean addStudentToLesson(String studentID, String courseID, String lessonID) throws Exception {
	
		
		
		ArrayList<Course> courses = (ArrayList<Course>) DatabaseHandler.getCourseData(); 
		
		
		
		for(Course course : courses) {
			if(course.getCourseID().equals(courseID) ) {
				for (Lessons lesson : course.getLessons()) {
					if(lesson.getLessonID().equals(lessonID)) {
						if(!studentInCourse(course, studentID)) {
							throw new Exception("Student not in course");
						}
						lesson.addStudent(studentID);
						DatabaseHandler.updateCourseData(courses);
						return true;
					}
				}
			}
		}
		return false;
		
	}

    /**
     * Checks if a given Student is registered in a given Lesson.
     * @param studentID the ID of the Student.
     * @param lesson the ID of the Lesson.
     * @return true if Student has registered for the Lesson and false if otherwise
     */
	public boolean studentRegisteredInLesson(String studentID, Lessons lesson) {
		for(String student : lesson.getstudentIDs()) {
			if(student.equals(studentID)) {
				return true;
			}
		}
		return false;
	}

    /**
     * Gets the Tutorial objects that belong to a given Course
     * @param course the <code>Course</code> object of interest.
     * @return <code>ArrayList</code> of <code>Tutorial</code> objects.
     */
	public ArrayList<Tutorial> getTutorials(Course course){
		ArrayList<Tutorial> tutorials = new ArrayList<Tutorial>();
		for(Lessons lesson : course.getLessons()) {
			if(lesson instanceof Tutorial) {
				tutorials.add((Tutorial)lesson);
			}
		}
		if(!tutorials.isEmpty()) {
			return tutorials;
		}else {
			return null;
		}
	}

    /**
     * Gets the Lab objects that belong to a given Course
     * @param course the <code>Course</code> object of interest.
     * @return <code>ArrayList</code> of <code>Lab</code> objects.
     */
	public ArrayList<Lab> getLabs(Course course){
		ArrayList<Lab> labs = new ArrayList<Lab>();
		for(Lessons lesson : course.getLessons()) {
			if(lesson instanceof Lab) {
				labs.add((Lab)lesson);
			}
		}
		if(!labs.isEmpty()) {
			return labs;
		}else {
			return null;
		}
	}

    /**
     * Checks if a given Student is registered in a given Course.
     * @param course ID of the Course.
     * @param studentID ID of the Student
     * @return true if Student is registered in the Course and false if otherwise
     */
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
