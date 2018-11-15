package courses;
import java.io.Serializable;
import java.util.*;


import functionalityClasses.CRUDByID;
import functionalityClasses.CourseCRUDByID;
import functionalityClasses.CourseUpdate;
import functionalityClasses.PrintByID;
import functionalityClasses.PrintCourseByID;
import functionalityClasses.Reset;
import functionalityClasses.ResetCourses;
import functionalityClasses.SetClassPartWeightage;
import functionalityClasses.SetCourseWorkWeightage;
import functionalityClasses.SetExamWeightage;
import functionalityClasses.SetWeightage;


import lessons.Lab;
import lessons.Lecture;
import lessons.LessonManager;
import lessons.Lessons;
import lessons.Tutorial;
import students.Student;
import students.StudentManager;
import util.DataBaseManager;
import util.DatabaseHandler;
import results.ResultManager;

/**
 * <code>CourseManager</code>
 * 
 * @author LFM
 */

public class CourseManager{
	private CRUDByID crudByID;
	private PrintByID print;
	private SetWeightage sCWW;
	private SetWeightage sCPW;
	private SetExamWeightage sEXW;
	private Reset reset;
	private LessonManager lm;
	private CourseUpdate update;
	
	
	
	
	public CourseManager() {
		this.crudByID = new CourseCRUDByID();
		this.sCWW = new SetCourseWorkWeightage();
		this.sCPW = new SetClassPartWeightage();
		this.sEXW = new SetExamWeightage();
		this.reset = new ResetCourses();
		this.print = new PrintCourseByID();
		this.lm = new LessonManager();
		this.update = new CourseUpdate();
		
	}

    // Adds a new course to the data base
    public void addNewCourse(String courseID, ArrayList<String> profNames) throws Exception{
        CourseCRUDByID courseCRUD = new CourseCRUDByID();
        courseCRUD.createByID(courseID);
        update.addProfNames(profNames, courseID);
    }

  
    
    // Registers a student to the course
	// Updates ArrayList<Student> in Course
	public void registerStudent(Student student, String courseID) throws Exception {
    	update.registerStudent(student, courseID);
    	
	// Result entry
    	ResultManager rm = new ResultManager();
    	rm.addResult(courseID, student.getStudentID());
    	
	}

	// Prints the students registered in a course
    public void printStudentsRegisteredInCourse(String courseID) throws Exception {
    	print.printByID(courseID);
    }
	 
    public void updateMaxVacancy(String courseID, int vacancy) throws Exception{
    	update.updateMaxVacancy(courseID,vacancy);
    }
	 
	 //Check Vacancy
	 private int getVacancy(String courseID) throws Exception{
		 return ((Course) crudByID.readByID(courseID)).getVacancy();
	 }
	 
	 private int getMaxVacancy(String courseID) throws Exception{
		 return ((Course) crudByID.readByID(courseID)).getMaxVacancy();
	 }
	 
	 public void printVacancy(String courseID) throws Exception{
		 System.out.println(getVacancy(courseID) + "/" + getMaxVacancy(courseID));
	 }
	 
	 
	 // Set Course Work Weightage
	public void setCourseworkWeightage(String courseID, int weightage) throws Exception{
		sCWW.setWeightage(courseID, weightage);
	}
	
	public void setClassParticipationWeightage(String courseID, int weightage) throws Exception{
		sCPW.setWeightage(courseID, weightage);
	}
	
	public void setExamWeightage(String courseID, int weightage) throws Exception{
		sEXW.setWeightage(courseID, weightage);
	}
	
	//Set course name
	public void updateCourseName(String courseID, String name) throws Exception{
		update.updateCourseName(courseID, name);
	}
	
	// get Course 
    public Course getCourse(String id) throws Exception {
		return (Course) crudByID.readByID(id); 	
    }
    
   // Prints all courses in the Database
    public void printCourses() throws Exception {
    	reset.printAll();
    }
    
    // Puts a new arraylise of courses in courses 
    public void resetCourses() throws Exception {
    	reset.reset();
    }

	
    // Add lessons
   public void addLesson(String courseID, int option, String lessonID, int vacancy) throws Exception {
	   lm.addLesson(courseID, option, lessonID, vacancy);
   }
    
    //Prints the lessons in the course 
	 public void printLessons(String id) throws Exception {
		lm.printAllLesson(id);
	 }
	 
	 public void printLesson(String courseID, String lessonID) throws Exception {
			lm.printLesson(courseID, lessonID);
		}
	 
	 public boolean hasTutorial(Course course) {
		 return lm.getTutorials(course) != null;
	 }
	 
	 public ArrayList<Tutorial> getTutorials(Course course){
		 return lm.getTutorials(course);
	 }
	 
	 public void printTutorials(Course course) {
		 ArrayList<Tutorial> tutorials = getTutorials(course);
		 for(Tutorial tutorial : tutorials) {
			 tutorial.printInfo();
		 }
	 }
	 
	 public boolean hasLab(Course course) {
		 return lm.getLabs(course) != null;
	 }
	 
	 public ArrayList<Lab> getLabs(Course course){
		 return lm.getLabs(course);
	 }
	 
	 public void printLabs(Course course) {
		 ArrayList<Lab> labs = getLabs(course);
		 for(Lab lab : labs) {
			 lab.printInfo();
		 }
	 }
}
