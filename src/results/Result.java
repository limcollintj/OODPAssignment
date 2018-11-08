package results;

import courses.Course;
import functionalityClasses.CourseCRUDByID;
import util.GradeCalculator;

/**
 * <code>Results</code> is an entity class representing the result of a particular student doing a particular course.
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class Result extends Score{

    /**
     * The ID of the Course that this Result is for.
     */
    private final String COURSE_ID;

    /**
     * The ID of the Student that this Result is for.
     */
    private final String STUDENT_ID;

    /**
     * Creates a new result for a given Student in a given Course based on their IDs.
     * @param courseID the ID of the <code>Course</code> this Result is for.
     * @param studentID the ID of the <code>Student</code> this Result is for
     * @param name TODO: WHAT IS NAME FOR
     */
	public Result(String courseID, String studentID, String name){
		super(name);
    	this.COURSE_ID = courseID;
    	this.STUDENT_ID = studentID;
	}

    /**
     * Gets the Course ID of the Course this Result is for.
     * @return the ID of the <code>Course</code>
     */
	public String getCourseID() {
    	return this.COURSE_ID;
    }

    /**
     * Gets the Student ID the Student this Result is for.
     * @return the ID of the <code>Student</code>
     */
    public String getStudentID() {
    	return this.STUDENT_ID;
    }

    /**
     * Prints this Result's information.
     * Information includes total score, exam score, coursework score and assignment and class participation score if subcomponents exist.
     * Grade will also be added.
     * @throws Exception
     */
    public void printInfo() throws Exception{
    	Course course = new CourseCRUDByID().readByID(COURSE_ID);
    	
    	System.out.println("Course ID: " + this.getCourseID() + 
				"\nOverall score: " + (this.getMark() == 0 ? "Score unavailable.":(this.getMark() + "%")) + 
				(course.getEXWeightage() != 0 ? 
				("\n\tExam score:        " + (this.getSubComponent().get(0).getMark() == 0 ? "Score unavailable.":(this.getSubComponent().get(0).getMark() + "%"))) : "")+
				(course.getCWWeightage() != 0 ?
				("\n\tCoursework score: " + (this.getSubComponent().get(1).getMark() == 0 ? "Score unavailable.":(this.getSubComponent().get(1).getMark()+ "%"))): "")+
				(course.getASWeightage() != 0 ?
				("\n\t\tAssignment score:          " + (this.getSubComponent().get(1).getSubComponent().get(0).getMark() == 0 ? "Score unavailable":(this.getSubComponent().get(1).getSubComponent().get(0).getMark() + "%"))):"")+
				(course.getCPWeightage() != 0 ?
				("\n\t\tClass Participation score: " + (this.getSubComponent().get(1).getSubComponent().get(1).getMark() == 0 ? "Score unavailable":(this.getSubComponent().get(1).getSubComponent().get(1).getMark() + "%"))):"")+
				"\n Overall grade:" + (this.getMark() == 0 ? "Grade unavailable.":GradeCalculator.calGrades(this.getMark()))
    			);
    	
    }
    
    
}
