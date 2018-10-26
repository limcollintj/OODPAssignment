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
    
    
   
  
   



    // Prints out the list of courses based on lecture, lab and tutorial group.
    public void printCourses() {
        for(CourseInfo temp : retrieveCourses()) {
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
    	
    	ArrayList<Lessons> temp = course.getLessons(); 
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
    
   
    
    

    // Adds a new course to the data base
    
    public void addNewCourse(String courseID, String[] lecturerID) {
       
        Course course = new Course(courseID,lecturerID, null);
        ArrayList<Course> temp = retrieveCourses();
        temp.add(course);
        updateCourseDatabase(temp);
        System.out.println("Course has been added to database.");
    }

  
    
    
    
    // Utility methods 
    
    // finds the course in database according to courseID
    /**
     * Returns a <code>Course</code> object corresponding to the course ID 
     * that can then be used to extract information of the specific 
     * course.
     * <p>
     * 
     * 
     * @param courseID - a unique ID corresponding to an existing Course
     * @return Course 
     * @see CourseInfo 
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
