package courses;

public class CourseOverall {
	private Course course;
	private CourseInfo courseInfo;
	
	public CourseOverall(String courseID, String courseName, int maxVacancy) {
		this.course = new Course(courseID, maxVacancy);
		this.courseInfo = new CourseInfo(courseID, maxVacancy);
	}
	
	
	
}
