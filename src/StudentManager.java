import java.io.Serializable;
import java.util.*;

public class StudentManager implements Serializable{
    private static final String STUDENT_FILENAME = "students.txt";

    // Adds a new student to the data base
    public void addNewStudent(String name, String matricNum) {
        Student student = new Student(name, matricNum);
        ArrayList<Student> temp = retrieveStudents();
        temp.add(student);
        updateStudentDatabase(temp);
        System.out.println("Student has been added.");
    }

    // Finds a student according to his studentID
    public Student getStudent(String studentID) {

        for (Student temp : retrieveStudents() ) {
            if(temp.getStudentID() == studentID) {
                return temp;
            }
        }
        System.out.println("This student cannot be found");
        return null;
    }

    public void registerCourse(String studentID, Course course) {

    }


    // Prints out the list of students
    public void printStudents() {
        for(Student temp : retrieveStudents()) {
            System.out.println("Name: " + temp.getName()+ "\nStudentID: "+ temp.getStudentID());
        }
    }

    // Database managers

    // Writes the object into the database
    public void updateStudentDatabase(Object obj){
        DataBaseManager.updateData(obj,STUDENT_FILENAME);
    }


    // Retrieves data from database
    public ArrayList<Student> retrieveStudents() {
        if((ArrayList<Student>) DataBaseManager.retrieveData(STUDENT_FILENAME) == null) {
            ArrayList<Student> students = new ArrayList<Student>();
            DataBaseManager.updateData(students, STUDENT_FILENAME);
            return students;
        }
        else {
            return (ArrayList<Student>) DataBaseManager.retrieveData(STUDENT_FILENAME);
        }
    }

}
