package lessons;

public class Lecture extends Lessons {
	private final String lessonID;
	
	public Lecture(String lessonID){
		this.lessonID = lessonID;
	}

	public String getLessonID() {
		return this.lessonID;
	}
	
	public void printInfo() {
		System.out.println("(Lecture) LessonID: " + lessonID + ", Vacancy:" + vacancy);
	}
}
