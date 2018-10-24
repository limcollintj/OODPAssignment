import java.io.Serializable;
import java.util.*;
import java.io.Serializable;

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

    //getters:
    public String getCourseID() {
        return courseID;
    }

    public String[] getLecturerID() {
        return lecturerID;
    }


}
