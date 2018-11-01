package lessons;

public class Tutorial extends Lessons{
	private final String lessonID;
	
	public Tutorial(String lessonID, int vacancy){
		this.lessonID = lessonID;
		this.vacancy = vacancy;
	}

	@Override 
	public String getLessonID() {
		return this.lessonID;
	}
	
	public void printInfo() {
		System.out.println("(Tutorial) LessonID: " + lessonID + ", Vacancy:" + vacancy);
	}
	
	
	
	
}