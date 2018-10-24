import java.io.Serializable;
import java.util.*;

public class CourseManager implements Serializable{
    private static final String COURSE_FILENAME = "Course.txt";
    Scanner sc = new Scanner("System.in");



    // Finds a course according to the courseID
    public Course getCourse(String courseID) {
        for (Course temp : retrieveCourses() ) {
            if(temp.getCourseID() == courseID) {
                return temp;
            }
        }
        System.out.println("This course cannot be found");
        return null;
    }

    // Adds a new course to the data base
    // COLLIN QUESTION: DOES THIS HAVE THE SAME ARRAYLIST AS THE ARRAYLIST<COURSE> in student or are they different??
    public void addNewCourse(String courseID, String[] lecturerID) {
        Course course1 = new Course(courseID, lecturerID);
        ArrayList<Course> temp = retrieveCourses();
        temp.add(course1);
        updateCourseDatabase(temp);
        System.out.println("Course has been added to database.");
    }

    //Adds lessons (labs/tutorials) to a new course.
    public void addLesson(Course course, String[] lessonIDs) {

    }

    public void editCourseWeightage(Course course) {
        System.out.println("Enter Exam Weightage (out of 100% course weightage): ");
        course.exWeightage = sc.nextInt();
        course.cwWeightage = 100 - course.exWeightage;
        System.out.println("The coursework weightage (out of 100% coursework weightage) is " + course.cwWeightage);
        System.out.println("Does the coursework have sub-components?\nY: Yes\nN: no");
        char in = sc.next().toUpperCase().charAt(0);
        if (in == 'Y') {
            course.haveSubComponents = true;
        }
        if (course.haveSubComponents) {
            System.out.println("Enter Assignment weightage (out of 100% coursework weightage): ");
            course.asWeightage = sc.nextInt();
            course.cpWeightage = 100 - course.asWeightage;
            System.out.println("The class participation weightage (out of 100% coursework weightage) is " + course.cpWeightage);
        }
        System.out.println("Course Weightage has been edited.");
    }



    // Prints out the list of courses based on lecture, lab and tutorial group.
    public void printCourses() {
        for(Course temp : retrieveCourses()) {
            //System.out.println("Name: " + temp.getName()+ "\nStudentID: "+ temp.getStudentID());
        }
    }

    // Database managers

    // Writes the object into the database
    public void updateCourseDatabase(Object obj){
        DataBaseManager.updateData(obj,COURSE_FILENAME);
    }


    // Retrieves data from database
    public ArrayList<Course> retrieveCourses() {
        if((ArrayList<Course>) DataBaseManager.retrieveData(COURSE_FILENAME) == null) {
            ArrayList<Course> courses = new ArrayList<Course>();
            DataBaseManager.updateData(courses, COURSE_FILENAME);
            return courses;
        }
        else {
            return (ArrayList<Course>) DataBaseManager.retrieveData(COURSE_FILENAME);
        }
    }

}
