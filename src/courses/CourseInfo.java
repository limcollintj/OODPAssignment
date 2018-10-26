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

    private String courseID;
    private String courseName;
    private String[] lecturerID;
    private int vacancy;
    boolean haveSubComponents;
    int exWeightage, cwWeightage, asWeightage, cpWeightage;
    ArrayList<Lessons> lessons;
    ArrayList<String> profNames;
    // shouldn't courses also have an arraylist of students??

    CourseInfo(String ID, String[] lecturerID) {
        this.courseID = ID;
        this.lecturerID = lecturerID;
        this.haveSubComponents = false;
        this.exWeightage = 0;
        this.cwWeightage = this.asWeightage = this.cpWeightage = 0;
        this.lessons = new ArrayList<Lessons>();
    }

    /**
     * Returns course ID of the <code>CourseInfo</code>
     * 
     * @return course ID
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * Return an array of IDs of lecturer-in-charge in no particular order.
     * 
     * @return <code>Array</code> of lecturer IDs
     */
    public String[] getLecturerID() {
        return lecturerID;
    }
}
