package lessons;

import java.util.ArrayList;

public class Lecture implements Lessons {

	
	private String[] studentIDs;
	private String lecturerID,lessonID;
	private int vacancy;
	
	public Lecture(String lecturerID, String lessonID, int vacancy){
		studentIDs = new String[vacancy]; 
		this.vacancy = vacancy; 
		this.lecturerID = lecturerID; 
		this.lessonID = lessonID;
	}
	
	
	@Override
	public void setlecturerID(String id) {
		this.lecturerID = id;
		
	}

	@Override
	public void setStudentIDs(String[] studentIDs) {
		this.studentIDs = studentIDs;
		
	}

	@Override
	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	@Override
	public void setLessonID(String id) {
		this.lessonID = id;
	}


	/**
	 * @return the studentIDs
	 */
	public String[] getStudentIDs() {
		return studentIDs;
	}


	/**
	 * @return the lecturerID
	 */
	public String getLecturerID() {
		return lecturerID;
	}


	/**
	 * @return the lessonID
	 */
	public String getLessonID() {
		return lessonID;
	}


	/**
	 * @return the vacancy
	 */
	public int getVacancy() {
		return vacancy;
	}


	@Override
	public String getstudentID() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void printInfo() {
		
			System.out.println("(Lecture) LessonID: " + lessonID + ", Vacancy:" + vacancy);
		

	}

 
	
	

}
