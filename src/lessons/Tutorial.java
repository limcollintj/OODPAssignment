package lessons;

/**
 * <code>Tutorial</code> is an entity class representing the lab sessions of a certain Course.
 * @author LFM
 * @version 1.0
 * @since 2018-11-07
 */
public class Tutorial extends Lessons{

    /**
     * the ID of this Tutorial
     */
	private final String lessonID;

    /**
     * Creates a new Tutorial object with the given ID and number of students who can register for it.
     * @param lessonID the ID of this Tutorial
     * @param vacancy the number of students who can register for this Tutorial
     */
	public Tutorial(String lessonID, int vacancy){
		super(vacancy);
		this.lessonID = lessonID;
		this.vacancy = vacancy;
	}

    /**
     * Gets the Lesson ID of this Tutorial.
     * @return the ID of this Tutorial
     */
	@Override 
	public String getLessonID() {
		return this.lessonID;
	}

    /**
     * Prints the Tutorial information.
     * This includes the Lab ID and vacancy of this Tutorial.
     * @throws Exception 
     */
	public void printInfo() throws Exception {

		System.out.println("(Tutorial) LessonID: " + lessonID + ", Vacancy:" + vacancy+ "/" + this.maxVacancy);
		super.printInfo();
	}
}