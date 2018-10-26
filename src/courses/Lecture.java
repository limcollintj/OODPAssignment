package courses;

public class Lecture implements Lessons {

	
	private String lecturereID, studentID;
	private int vacancy;
	
	@Override
	public void setlecturerID(String id) {
		this.lecturereID = id;
		
	}

	@Override
	public void setStudentIDs(String id) {
		this.studentID = id;
		
	}

	@Override
	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	@Override
	public void setLessonID(String id) {
		
		
	}

 

}
