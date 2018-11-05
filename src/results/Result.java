package results;

<<<<<<< HEAD
import util.Grades;
import courses.Course;
import functionalityClasses.CourseCRUDByID;
=======
import util.GradeCalculator;

>>>>>>> 57be7595cd88aa8aca8c249d49019bfc58fc671b

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
				"\n Overall grade:" + (this.getMark() == 0 ? "Grade unavailable.":Grades.calGrades(this.getMark()))
    			);
    	
    }
    
    
}
