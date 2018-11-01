package lessons;

public class Tutorial extends Lessons{
	private final String lessonID;
	
	public Tutorial(String lessonID){
		this.lessonID = lessonID;
	}

	public String getLessonID() {
		return this.lessonID;
	}
	
	public void printInfo() {
		System.out.println("(Tutorial) LessonID: " + lessonID + ", Vacancy:" + vacancy);
	}
}