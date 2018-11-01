package courses;
import java.io.Serializable;
import java.util.*;


import functionalityClasses.CRUDByID;
import functionalityClasses.CourseCRUDByID;
import functionalityClasses.PrintByID;
import functionalityClasses.PrintCourseByID;
import functionalityClasses.Reset;
import functionalityClasses.ResetCourses;
import functionalityClasses.SetClassPartWeightage;
import functionalityClasses.SetCourseWorkWeightage;
import functionalityClasses.SetWeightage;


import lessons.Lab;
import lessons.Lecture;
import lessons.Lessons;
import lessons.Tutorial;
import students.Student;
import students.StudentManager;
import util.DataBaseManager;
import results.ResultManager;

/**
 * <code>CourseManager</code>
 * 
 * @author LFM
 */
// Problems: When you add Students into a course, only the course copy gets updated(Vacancy Reduces). The student copy remains the same. : Work around is to Store a reference in the student copy. 
//TODO: Decide whether we are using id or the object itself


public class CourseManager{
	private CRUDByID crudByID;
	private PrintByID print;
	private SetWeightage sCWW;
	private SetWeightage sCPW;
	private Reset reset;
	
	
	
	
	public CourseManager() {
		this.crudByID = new CourseCRUDByID();
		this.sCWW = new SetCourseWorkWeightage();
		this.sCPW = new SetClassPartWeightage();
		this.reset = new ResetCourses();
		this.print = new PrintCourseByID();
		
	}

    // Adds a new course to the data base
    public void addNewCourse(String courseID, ArrayList<String> profNames) throws Exception{
        CourseCRUDByID courseCRUD = new CourseCRUDByID();
        courseCRUD.createByID(courseID);
    }

  
    
    // Registers a student to the course
	// Updates ArrayList<Student> in Course
	public void registerStudent(Student student, String courseID) throws Exception {
    	for(Course course : this.courses) {
    		if(course.getCourseID().equals(courseID)) {
    			course.addStudent(student);
    			course.reduceVacancy();
    		}
    	}
    	
    	
    //Add Result entry
    	ResultManager rm = new ResultManager();
    	rm.addResult(courseID, student.getStudentID());
    	updateCourseDatabase(this.courses);
	}
	
	

	// Prints the students registered in a course
    public void printStudentsRegisteredInCourse(String courseID) throws Exception {
    	print.printByID(courseID);
    }
	
    
    
	// Adds new lesson to course 
	// Updates ArrayList<Lesson> in Course 
    
	 public void addLesson(Course course,int option, String lessonID, String lecturerID, int vacancy, String groupID) {
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
	    	temp.add(les);
	    	updateCourseDatabase(temp);
	    }
	 
	 
	 
	 //Check Vacancy
	 private int getVacancy(String courseID) throws Exception{
		 return ((Course) crudByID.readByID(courseID)).getVacancy();
	 }
	 
	 private int getMaxVacancy(String courseID) throws Exception{
		 return ((Course) crudByID.readByID(courseID)).getMaxVacancy();
	 }
	 
	 public void printVacancy(String courseID) throws Exception{
		 System.out.println(getVacancy(courseID) + "/" + getMaxVacancy(courseID));
	 }
	 
	 
	 
	
	 
	 
	 // Set Course Work Weightage
	public void setCourseworkWeightage(String courseID, int weightage) throws Exception{
		sCWW.setWeightage(courseID, weightage);
	}
	
	public void setClassParticipationWeightage(String courseID, int weightage) throws Exception{
		sCPW.setWeightage(courseID, weightage);
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
   
    
    
    // Find Lesson 
    public Lessons findLesson(String lessonID) {
    	for(Lessons temp : lessons) {
    		if(temp.getLessonID() == lessonID) {
    			return temp;
    		}
    	}
    	return null;
    }
    
    //Prints the lessons in the course 
	 public void printLessons(String id) throws Exception {
		 Course temp = getCourse(id); 
			for(Lessons lesson : temp.getLessons()) {
	    		lesson.printInfo();
	    	}
	 }
    
    // Remove lessons
    public void removeLessons(String lessonID) {
    	for(Lessons temp : lessons) {
    		if(temp.getLessonID() == lessonID) {
    			lessons.remove(temp);
    		}
    	}
    }
    

    // Testing methods : Methods for testing database 
    
    // These methods are not to be used for actual app usage 
    public void printCourses() throws Exception {
    	reset.printAll();
    }
    

    public void resetCourses() throws Exception {
    	reset.reset();
    }
    
    
    

}
