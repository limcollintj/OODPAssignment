package students;
import java.util.*;

import courses.Course;
import lessons.LessonManager;
import functionalityClasses.CRUDByID;
import functionalityClasses.PrintByID;
import functionalityClasses.PrintStudentByID;
import functionalityClasses.Reset;
import functionalityClasses.ResetStudents;
import functionalityClasses.StudentCRUDByID;
import functionalityClasses.StudentUpdate;

/**
 * <code>CourseManager</code>
 *
 * @author LFM
 */

public class StudentManager{


    private Reset reset;
    private CRUDByID crudID;
    private PrintByID pbID;
    private StudentUpdate update;

    /**
     * Construct a student manager for a particular student
     */
    public StudentManager() {
    	this.reset = new ResetStudents();
    	this.crudID = new StudentCRUDByID();
    	this.pbID = new PrintStudentByID();
    	this.update = new StudentUpdate();
    	
    }
    
    // Adds a new student to the data base/**
    /**
     * Adds a new student
     * @param name Student's name
     * @param id Student's ID
     * @throws Exception
     */
    public void addNewStudent(String name, String id) throws Exception {
    	crudID.createByID(id);
    	update.addName(id, name);
    }

    
    
    // Registers a student to the course

    /**
     * Registers a student for a course
     * @param studentId Student's ID
     * @param course Course object
     * @throws Exception
     */
    public void registerCourse(String studentId, Course course) throws Exception{
    	update.registerCourse(course, studentId);
    }
    
    //Registers a student to lesson
    /**
     * Registers a student for a lesson in the course
     * @param studentID Student's ID
     * @param courseID Course ID
     * @param lessonID Lesson ID
     * @return true if student is registered to lesson
     * @throws Exception
     */
	public boolean registerStudentToLesson(String studentID, String courseID, String lessonID) throws Exception {
		return new LessonManager().addStudentToLesson(studentID, courseID, lessonID);
	}


    /**
     * Fetch student object
     * @param id Student's ID
     * @return Student object
     * @throws Exception
     */
    public Student getStudent(String id) throws Exception {
		return (Student) crudID.readByID(id);
    }
    
    // Prints out the courses a student has registered in
    /**
     * Prints out all the courses that a student has registered in
     * @param studentID Student's ID
     * @throws Exception
     */
    public void printCoursesRegistered(String studentID) throws Exception {
    	pbID.printByID(studentID);
    }
    
    
    // Prints out all the students and its course information

    /**
     * Prints out a list of all students
     * @throws Exception
     */
    public void printStudents() throws Exception{
        reset.printAll();
    }
  
    
    // Resets the students database

    /**
     * Resets the list of students
     * @throws Exception
     */
    public void resetStudents() throws Exception {
    	reset.reset();
    }
    
    
}
