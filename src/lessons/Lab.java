package lessons;

import java.util.ArrayList;

public class Lab extends Lessons{
	private final String lessonID;
	
	public Lab(String profName, String lessonID, int vacancy, String groupID){
		studentIDs = new ArrayList<String>(vacancy); 
		this.vacancy = vacancy; 
		this.profName = profName;
		this.lessonID = lessonID;
	}

	public String getLessonID() {
		return this.lessonID;
	}
	
	public void printInfo() {
		System.out.println("(Lab) LessonID: " + lessonID + ", Vacancy:" + vacancy);
	}

}
