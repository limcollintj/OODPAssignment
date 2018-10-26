package courses;
import java.io.Serializable;
import java.util.*;
import java.io.Serializable;

/**
 * <code>CourseInfo</code> is a serializable entity class. <code>CourseInfo</code> stores the following
 * information:
 * <ul>
 * <li> course ID
 * <li> Array of lecturer ID
 * <li> <code>ArrayList</code> of {@link Lessons} 
 * <li> Weightages of the respective {@link Results} of each component <code>Lesson</code>
 * </ul>
 * 
 * The course ID should be unique to ensure that no duplicates are created.
 * 
 * @author LFM
 */
public class CourseInfo implements Serializable {

    private final String courseID;
    private String courseName;
    private final int maxVacancy;
    boolean haveSubComponents;
    int exWeightage, cwWeightage, asWeightage, cpWeightage;
    ArrayList<Lessons> lessons;
    ArrayList<String> profNames;

    CourseInfo(String ID, int maxVacancy) {
        this.courseID = ID;
        this.profNames = new ArrayList<String>();
        this.maxVacancy = maxVacancy;
        this.courseName = "Unknown Course";
        this.haveSubComponents = false;
        this.exWeightage = this.cwWeightage = this.asWeightage = this.cpWeightage = 0;
        this.lessons = new ArrayList<Lessons>();
    }

    /**
     * Returns course ID of the <code>CourseInfo</code>
     * 
     * @return course ID
     */
    public String getCourseID() {
        return this.courseID;
    }
    
    public String getCourseName() {
    	return this.courseName;
    }
    
    public void setCourseName(String courseName) {
    	this.courseName = courseName;
    }
    /**
     * Return an array of names of lecturer-in-charge in no particular order.
     * 
     * @return <code>Array</code> of lecturer IDs
     */
    public ArrayList<String> getProfNames() {
        return this.profNames;
    }
    
    public void addProfName(String profName) {
    	this.profNames.add(profName);
    }
    
    public int getMaxVacancy() {
    	return this.maxVacancy;
    }
    
    public ArrayList<Lessons> getLessons(){
    	return this.lessons;
    }
    
    public void addLessons(Lessons lesson) {
    	this.lessons.add(lesson);
    }
    
    private boolean validWeightage(){
    	return (this.exWeightage + this.cwWeightage + this.asWeightage + this.cpWeightage) == 100;
    }
}
