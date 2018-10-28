package results;

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
}
