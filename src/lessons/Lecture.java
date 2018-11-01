package lessons;

import java.io.Serializable;

public class Lecture extends Lessons implements Serializable{
	private final String lessonID;
	
	public Lecture(String lessonID, int vacancy){
		this.lessonID = lessonID;
		this.vacancy = vacancy;
	}

	@Override 
	public String getLessonID() {
		return this.lessonID;
	}
	
	public void printInfo() {
		System.out.println("(Lecture) LessonID: " + lessonID + ", Vacancy:" + vacancy);
	}
}
