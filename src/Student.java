import java.io.Serializable;
import java.util.*;

public class Student implements Serializable{

    private String name, studentID;
    ArrayList<Course> courses;


    Student(String name, String matricNumber){
        this.name = name;
        this.studentID = matricNumber;
        this.courses = new ArrayList<Course>();
    }


    // getters:
    public String getName() {
        return name;
    }

    public String getStudentID() {
        return studentID;
    }

    // Setters:
    public void setName(String name) {
        this.name = name;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

}
