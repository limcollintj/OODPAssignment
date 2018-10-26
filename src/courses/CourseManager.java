package courses;
import java.io.Serializable;
import java.util.*;

import util.DataBaseManager;

/**
 * <code>CourseManager</code>
 * 
 * @author LFM
 */
public class CourseManager{
	
	
	
	

    private static final String COURSE_FILENAME = "Course.txt";
    
    
    /**
     * Returns a <code>Course</code> object corresponding to the course ID 
     * that can then be used to extract information of the specific 
     * course.
     * <p>
     * 
     * 
     * @param courseID - a unique ID corresponding to an existing Course
     * @return Course 
     * @see Course 
     */
    
    
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
        Course course1 = new Course(courseID);
        Course course = new Course(courseID);
        ArrayList<Course> temp = retrieveCourses();
        temp.add(course1);
        updateCourseDatabase(temp);
        System.out.println("Course has been added to database.");
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
    
    
    
    
    
    
    

    
    
    
    
    
    // Lessons logic
  
    // Add Lessons
    // Adding lesson according to your choice
    // Option: 1--> Lab, Option: 2--> Tutorial, Option: 3 --> Lecture
    // Creates a new lesson and adds it into the course
    
    // Comments: 
    // Max Vacancy cannot be changed
    // groupID argument is set as 0 adding of lectures 
    
    
    
    // Add lessons
    public void addLessons(CourseOverall co,int option, String lessonID, String lecturerID, int vacancy, String groupID) {
    	Lessons les = null;
    	
    	switch(option) {
    	case 1: 
    		les = new Tutorial(lecturerID, lessonID, vacancy, groupID); 
    		break; 
    	case 2: 
    		les = new Lab(lecturerID, lessonID, vacancy, groupID);
    		break; 
    	case 3: 
    		les = new Lecture(lecturerID, lessonID, vacancy); 
    		break;
    	
    	}
    	
    	ArrayList<Lessons> temp = courseInfo.getLessons(); 
    	lessons.add(les);
    	
    	
    	
    	
    }
    
    
    // Find Lesson 
    public Lessons findLesson(String lessonID) {
    	
    	for(Lessons temp : lessons) {
    		if(temp.getLessonID() == lessonID) {
    			return temp;
    		}
    	}
    	return null;
    }
    
    
    // Remove lessons
    public void removeLessons(String lessonID) {
    	for(Lessons temp : lessons) {
    		if(temp.getLessonID() == lessonID) {
    			lessons.remove(temp);
    		}
    	}
    }
    
   
    
    
    

    // Database handlers

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
