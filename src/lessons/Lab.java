package lessons;

/**
 * <code>Lab</code> is an entity class representing the lab sessions of a certain Course.
 * @author LFM
 * @version 1.0
 * @since 2018-11-07
 */
public class Lab extends Lessons{

    /**
     * the ID of this Lab
     */
    private final String lessonID;

    /**
     * Creates a new Lab object with the given ID and number of students who can register for it.
     * @param lessonID the ID of this Lab
     * @param vacancy the number of students who can register for this Lab
     */
	public Lab(String lessonID, int vacancy){
		super(vacancy);
		this.lessonID = lessonID;
		this.vacancy = vacancy;
	}

    /**
     * Gets the Lesson ID of this Lab.
     * @return the ID of this Lab
     */
	@Override
	public String getLessonID() {
		return this.lessonID;
	}

    /**
     * Prints the Lab information.
     * This includes the Lab ID and vacancy of this Lab.
     * @throws Exception 
     */
	public void printInfo() throws Exception {

		System.out.println("(Lab) LessonID: " + lessonID + ", Vacancy:" + vacancy + "/" + this.maxVacancy);
		super.printInfo();

	}

}
