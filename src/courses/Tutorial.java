package courses;



public class Tutorial extends Group{

	private String[] studentIDs;
	private String lecturerID,lessonID,groupID;
	private int vacancy;
	
	Tutorial(String lecturerID, String lessonID, int vacancy, String groupID){
		studentIDs = new String[vacancy]; 
		this.groupID = groupID; 
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

	@Override
	public void setGroupID(String id) {
		this.groupID = id;
		
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
	 * @return the groupID
	 */
	public String getGroupID() {
		return groupID;
	}


	/**
	 * @return the vacancy
	 */
	public int getVacancy() {
		return vacancy;
	}
	
	

  

}