import java.io.Serializable;
import java.util.*;
import java.io.Serializable;

/**
 * <code>Course</code> is a serializable entity class. <code>Course</code> stores the following
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
public class Course implements Serializable {

    private String courseID;
    private String[] lecturerID;
    boolean haveSubComponents;
    int exWeightage, cwWeightage, asWeightage, cpWeightage;
    ArrayList<Lessons> lessons;
    // shouldn't courses also have an arraylist of students??

    Course(String ID, String[] lecturerID) {
        this.courseID = ID;
        this.lecturerID = lecturerID;
        this.haveSubComponents = false;
        this.exWeightage = 0;
        this.cwWeightage = this.asWeightage = this.cpWeightage = 0;
        this.lessons = new ArrayList<Lessons>();
    }

    /**
     * Returns course ID of the <code>Course</code>
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
