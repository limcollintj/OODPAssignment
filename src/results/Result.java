package results;

import util.GradeCalculator;


public class Result extends Score{
    private final String COURSE_ID;
    private final String STUDENT_ID;
    
	public Result(String courseID, String studentID, String name){
		super(name);
    	this.COURSE_ID = courseID;
    	this.STUDENT_ID = studentID;
	}
	
	public String getCourseID() {
    	return this.COURSE_ID;
    }
    
    public String getStudentID() {
    	return this.STUDENT_ID;
    }
    
    public void printInfo() {
    	System.out.println("Course ID: " + this.getCourseID() + 
				"\nOverall score: " + this.getMark() + "%"+
				"\n\tExam score:        " + this.getSubComponent().get(0).getMark()+ "%"+
				"\n\tCoursework score: " + this.getSubComponent().get(1).getMark()+ "%"+
				"\n\t\tAssignment score:          " + this.getSubComponent().get(1).getSubComponent().get(0).getMark()+ "%"+
				"\n\t\tClass Participation score: " + this.getSubComponent().get(1).getSubComponent().get(1).getMark() + "%"+
				"\n Overall grade:" + GradeCalculator.calGrades(this.getMark()) + "\n"
    			);
    	
    }
    
    
}
