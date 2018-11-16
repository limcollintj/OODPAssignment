package lessons;

import java.io.Serializable;

/**
 * <code>Lecture</code> is a serializable entity class representing the lab sessions of a certain Course.
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public class Lecture extends Lessons implements Serializable{

    /**
     * the ID of this Lecture
     */
    private final String lessonID;

    /**
     * Creates a new Lecture object with the given ID and number of students who can register for it.
     * @param lessonID the ID of this Lecture
     * @param vacancy the number of Students who can register for this Lecture
     */
	public Lecture(String lessonID, int vacancy){
		super(vacancy);
		this.lessonID = lessonID;
		this.vacancy = vacancy;

	}

    /**
     * Gets the Lesson ID of this Lecture.
     * @return the ID of this Lecture
     */
	@Override 
	public String getLessonID() {
		return this.lessonID;
	}

    /**
     * Prints the Lecture information.
     * This includes the Lecture ID and vacancy of this Lecture.
     * @throws Exception 
     */
	public void printInfo() throws Exception {
		System.out.println("(Lecture) LessonID: " + lessonID + ", Vacancy:" + vacancy + "/" + this.maxVacancy);
		super.printInfo();	//Prints list of student registered in this Lecture

	}
}
