package lessons;

public class Lab extends Lessons{
	private final String lessonID;
	
	public Lab(String lessonID){
		this.lessonID = lessonID;
	}

	public String getLessonID() {
		return this.lessonID;
	}
	
	public void printInfo() {
		System.out.println("(Lab) LessonID: " + lessonID + ", Vacancy:" + vacancy);
	}

}
