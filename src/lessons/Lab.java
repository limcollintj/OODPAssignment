package lessons;

public class Lab extends Lessons{
	private final String lessonID;
	
	public Lab(String lessonID, int vacancy){
		this.lessonID = lessonID;
		this.vacancy = vacancy;
	}

	@Override 
	public String getLessonID() {
		return this.lessonID;
	}
	
	public void printInfo() {
		System.out.println("(Lab) LessonID: " + lessonID + ", Vacancy:" + vacancy);
		super.printInfo();
	}

}
