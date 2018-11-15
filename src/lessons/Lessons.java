package lessons;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * <code>Lessons</code> is a serializable entity class representing the lessons each course has.
 * Lessons include labs, lectures and tutorials.
 * @author LFM
 * @version 1.0
 * @since 2018-11-07
 */
public abstract class Lessons implements Serializable {

    /**
     * An ArrayList that stores the ID's of the Students registered for this Lesson.
     */
    protected ArrayList<String> studentIDs;

    /**
     * The name of the professor teaching this Lesson.
     */
    protected String profName;

    /**
     * The remaining number of Students who can register for this Lesson.
     */
    protected int vacancy;

    /**
     * Creates a new Lesson object.
     * The object starts with no Students registered for this Lesson.
     */
	public Lessons(int maxVacancy) {
		this.studentIDs= new ArrayList<String>();
		this.maxVacancy = maxVacancy;
	}

	
	protected int maxVacancy;
    /**
     * Sets the name of the Professor teaching this Lesson.
     * @param name new name of Professor.
     */
    public void setprofName(String name) {
    	this.profName = name;
    }

    /**
     * Registers a Student for this Lesson.
     * This decreases the remaining vacancies for this Lesson by 1.
     * @param id ID of the <code>Student</code> registering for this Lesson.
     */
    public void addStudent(String id) {
    	this.studentIDs.add(id);
    	this.vacancy--;
    	
    }

    /**
     * Sets the Students registered for this Course with a predetermined list of Students
     * @param studentIDs <code>ArrayList</code> of Student IDs of Students registering for this Lesson.
     */
    public void setStudentIDs(ArrayList<String> studentIDs) {
    	this.studentIDs = studentIDs;
    }

    /**
     * Sets the number of vacancies for this Lesson.
     * @param vacancy the new vacancy number.
     */
    public void setVacancy(int vacancy) {
    	this.vacancy = vacancy;
    }

    /**
     * Gets the lessonID of this Lesson
     * @return a <code>String</code> representing this Lesson's ID.
     */
    abstract String getLessonID();

    /**
     * Gets the name of the Professor teaching this Lesson.
     * @return the name of the Professor.
     */
    public String getProfName() {
    	return this.profName;
    }

    /**
     * Gets the list of Student ID's of Students registered for this Lesson.
     * @return an <code>ArrayList</code> of Student IDs.
     */
    public ArrayList<String> getstudentIDs() {
    	return this.studentIDs;
    }

    /**
     * Gets the number of vacancies for this Lesson.
     * @return the number of vacancies.
     */
    public int getVacancy() {
    	return this.vacancy;
    }
    

    /**
     * Prints the Lesson Information of this Lesson, Including the students who are registered in the course.
     */
    public void printInfo() {
    	System.out.println("<----Students Registered In Course--->");
    	for(String studentID : studentIDs) {
    		System.out.println(studentID);
    	}
    };

}