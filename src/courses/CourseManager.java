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
 * <code>CourseManager</code> is a control class that handles the operations done to the <code>Course</code> entity class objects.
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class CourseManager{

    /**
     * This Course Manager's <code>CourseCRUD</code> object.
     */
    private CRUDByID crudByID;

    /**
     * This Course Manager's <code>PrintByID</code> object.
     */
    private PrintByID print;

    /**
     * This Course Manager's <code>SetWeightage</code> object.
     */
	private SetWeightage sCWW;

    /**
     * TODO: why is it again?
     */
	private SetWeightage sCPW;
	private SetExamWeightage sEXW;

    /**
     * This Course Manager's <code>Reset</code> object.
     */
	private Reset reset;

    /**
     * This Course Manager's <code>Lesson Manager</code> object.
     */
	private LessonManager lm;

    /**
     * This Course Manager's <code>Course Update</code> object.
     */
	private CourseUpdate update;


    /**
     * Creates a new course manager.
     * <code>Course Manager</code> automatically instantiates objects of the following classes and saves the objects as attributes.
     * Classes are <code>CourseCRUDByID</code>, <code>SetCourseWorkWeightage</code>, <code>SetClassPartWeightage</code>, <code>ResetCourses</code>, <code>PrintCourseByID</code>, <code>LessonManager</code> and <code>CourseUpdate</code>
     */
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

    /**
     * Adds a new Course into the course database.
     * @param courseID ID of the new <code>Course</code>.
     * @param profNames <code>ArrayList</code> of Strings which represent the names of the Professor's teaching the Course.
     * @throws Exception
     */
    public void addNewCourse(String courseID, ArrayList<String> profNames) throws Exception{
        CourseCRUDByID courseCRUD = new CourseCRUDByID();
        courseCRUD.createByID(courseID);
        update.addProfNames(profNames, courseID);
    }


    /**
     * Registers a Student for a given Course
     * @param student <code>Student</code> object who is registered for the course
     * @param courseID ID of the <code>Course</code> student is registering for.
     * @throws Exception
     */
	public void registerStudent(Student student, String courseID) throws Exception {
    	update.registerStudent(student, courseID);
    	
    	ResultManager rm = new ResultManager();
    	rm.addResult(courseID, student.getStudentID());
    	
	}

    /**
     * Prints the information of students of a given Course.
     * @param courseID ID of the <code>Course</code>
     * @throws Exception
     */
    public void printStudentsRegisteredInCourse(String courseID) throws Exception {
    	print.printByID(courseID);
    }

    /**
     * Sets the maximum student capacity of a given Course.
     * @param courseID ID of the <code>Course</code> of interest.
     * @param vacancy the new maximum student capacity.
     * @throws Exception
     */
    public void updateMaxVacancy(String courseID, int vacancy) throws Exception{
    	update.updateMaxVacancy(courseID,vacancy);
    }

    /**
     * Gets the current student capacity of a given Course.
     * @param courseID ID of the <code>Course</code> of interest.
     * @return the current student capacity
     * @throws Exception
     */
	 private int getVacancy(String courseID) throws Exception{
		 return ((Course) crudByID.readByID(courseID)).getVacancy();
	 }

    /**
     * Gets the total student capacity of a given Course.
     * @param courseID ID of the <code>Course</code> of interest.
     * @return the total student capacity
     * @throws Exception
     */
	 private int getMaxVacancy(String courseID) throws Exception{
		 return ((Course) crudByID.readByID(courseID)).getMaxVacancy();
	 }

    /**
     * Prints the ratio of number of vacancies over total student capacity of a given Course
     * @param courseID ID of the <code>Course</code> of interest
     * @throws Exception
     */
	 public void printVacancy(String courseID) throws Exception{
		 System.out.println(getVacancy(courseID) + "/" + getMaxVacancy(courseID));
	 }

    /**
     * Sets the coursework weightage of a given Course.
     * @param courseID ID of the <code>Course</code> of interest
     * @param weightage new weightage of the coursework component
     * @throws Exception
     */
	public void setCourseworkWeightage(String courseID, int weightage) throws Exception{
		sCWW.setWeightage(courseID, weightage);
	}

    /**
     * Sets the class participation weightage of a given Course.
     * @param courseID ID of the <code>Course</code> of interest
     * @param weightage new weightage of the class participation component
     * @throws Exception
     */
	public void setClassParticipationWeightage(String courseID, int weightage) throws Exception{
		sCPW.setWeightage(courseID, weightage);
	}
<<<<<<< HEAD
	
	public void setExamWeightage(String courseID, int weightage) throws Exception{
		sEXW.setWeightage(courseID, weightage);
	}
	
	//Set course name
=======

    /**
     * Sets the name of a given Course.
     * @param courseID ID of the <code>Course</code> of interest
     * @param name new name of the Course
     * @throws Exception
     */
>>>>>>> efdbc74980c72f48d7e90c9b53ebe5f81b44e8e7
	public void updateCourseName(String courseID, String name) throws Exception{
		update.updateCourseName(courseID, name);
	}

    /**
     * Searches and returns a Course object which has a given Course ID.
     * @param id ID of the <code>Course</code> of interest
     * @return the <code>Course</code> object which has the given Course ID
     * @throws Exception
     */
    public Course getCourse(String id) throws Exception {
		return (Course) crudByID.readByID(id); 	
    }

    /**
     * Prints all Courses and its information from the database.
     * Course Information contains this Course's ID, vacancy number, Coordinator's name and Professor's name.
     * @throws Exception
     */
    public void printCourses() throws Exception {
    	reset.printAll();
    }

    /**
     * Resets all Courses in the database by replacing the ArrayList of courses with a new ArrayList.
     * @throws Exception
     */
    public void resetCourses() throws Exception {
    	reset.reset();
    }

    /**
     * Adds a Lesson object into the ArrayList of Lessons belonging to a certain Course.
     * @param courseID the course ID of the <code>Course</code> which the lesson is going to be added to.
     * @param option the type of <code>Lesson</code> object to be created. (tutorial/lab/lecture)
     * @param lessonID the lesson ID of the <code>Lesson</code> going to be added to a <code>Course</code>.
     * @param vacancy the number of students the <code>Lesson</code> can hold.
     * @throws Exception
     */
   public void addLesson(String courseID, int option, String lessonID, int vacancy) throws Exception {
	   lm.addLesson(courseID, option, lessonID, vacancy);
   }

    /**
     * Prints all the lessons belonging to a specific Course.
     * lessons include labs/tutorials/lectures.
     * @param id the course ID of the intended <code>Course</code>.
     * @throws Exception
     */
	 public void printLessons(String id) throws Exception {
		lm.printAllLesson(id);
	 }

    /**
     * Prints the a specific Lesson information of lab/tutorial/lecture belonging to a certain Course
     * Lesson information includes the lesson ID and vacancy in this Lesson group.
     * @param courseID the course ID of the intended <code>Course</code>.
     * @param lessonID the lesson ID of the intended <code>Lesson</code>.
     */
	 public void printLesson(String courseID, String lessonID) throws Exception {
			lm.printLesson(courseID, lessonID);
		}

    /**
     * Indicates if a certain Course has tutorial(s) in their curriculum
     * @param course <code>Course</code> whose curriculum structure is of interest
     * @return true if <code>Course</code> has tutorial and false if otherwise.
     */
	 public boolean hasTutorial(Course course) {
		 return lm.getTutorials(course) != null;
	 }

    /**
     * Gets an ArrayList of Tutorial objects which are tutorials belonging to a certain Course.
     * @param course <code>Course</code> whose tutorials we are interested in
     * @return <code>ArrayList</code> of Tutorial objects
     */
	 public ArrayList<Tutorial> getTutorials(Course course){
		 return lm.getTutorials(course);
	 }

    /**
     * Prints the Tutorial information of tutorials belonging to a certain Course
     * Tutorial information includes the tutorial ID and vacancy in this Tutorial group.
     * @param course <code>Course</code> whose Tutorial information we intend to print
     */
	 public void printTutorials(Course course) {
		 ArrayList<Tutorial> tutorials = getTutorials(course);
		 for(Tutorial tutorial : tutorials) {
			 tutorial.printInfo();
		 }
	 }

    /**
     * Indicates if a certain Course has lab(s) in their curriculum
     * @param course <code>Course</code> whose curriculum structure is of interest
     * @return true if <code>Course</code> has lab and false if otherwise.
     */
	 public boolean hasLab(Course course) {
		 return lm.getLabs(course) != null;
	 }

    /**
     * Gets an ArrayList of Lab objects which are labs belonging to a certain Course.
     * @param course <code>Course</code> whose labs we are interested in
     * @return <code>ArrayList</code> of Lab objects
     */
	 public ArrayList<Lab> getLabs(Course course){
		 return lm.getLabs(course);
	 }

    /**
     * Prints the Lab information of labs belonging to a certain Course
     * Lab information includes the Lab ID and vacancy in this Lab.
     * @param course <code>Course</code> whose Lab information we intend to print
     */
	 public void printLabs(Course course) {
		 ArrayList<Lab> labs = getLabs(course);
		 for(Lab lab : labs) {
			 lab.printInfo();
		 }
	 }
	 
	
}
