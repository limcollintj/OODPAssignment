package results;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * <code>Score</code> is an abstract Serializable entity class.
 * It represents the framework for marks of each course that a student registers for.
 * @author LFM
 * @version 1.0
 * @since 2018-11-07
 */
public abstract class Score  implements Serializable{

    /**
     * todo: what is this
     */
    private final String NAME;

    /**
     * An ArrayList of Scores
     */
    private ArrayList<Score> subComponent = new ArrayList<Score>();

    /**
     * The maximum mark of this Score which is 100.
     */
    private double maxMark = 100;

    /**
     * The initialised mark of this Score which is 0.
     */
    private double mark = 0;

    /**
     * Instantiates a <code>Score</code> object.
     * @param name todo: idk
     */
    public Score(String name) {
    	this.NAME = name;
    }

    /**
     * Gets the mark of this Score.
      * @return this Score's mark.
     */
    public double getMark(){
    	return this.mark;
    }

    /**
     * Sets the mark of this Score.
     * The mark must have a value greater than or equal to 0.
     * The mark cannot be greater than this Score's maximum mark.
     * @param mark the new mark of this Score.
     */
    public void setMark(double mark) {
    	if(mark < 0) {
    		throw new IllegalArgumentException("Mark must be >= 0");
    	}
    	if(mark > maxMark) {
    		throw new IllegalArgumentException("Mark cannot be greater than max. mark.");
    	}
    	this.mark = mark;
    }

    /**
     * Gets the maximum mark of this Score.
     * @return this Score's maximum mark.
     */
    public double getMaxMark() {
    	return this.maxMark;
    }

    /**
     * Sets the maximum mark of this Score.
     * The maximum mark must have a value greater than 0.
     * @param mark the new maximum mark of this Score
     */
    public void setMaxMark(int mark) {
    	if(mark <= 0) {
    		throw new IllegalArgumentException("Max mark must be > 0.");
    	}
    	this.maxMark = mark;
    }

    /**
     * todo: whats name?
     * @return
     */
    public String getName() {
    	return this.NAME;
    }

    /**
     * Adds a score object to the ArrayList representing any subcomponent this Score object might have.
     * @param score new <code>Score</code> object to be added.
     */
    public void addSubComponent(Score score){
		subComponent.add(score);
	}

    /**
     * Get the Scores of subcomponents for this Score.
     * @return <code>ArrayList</code> of <code>Score</code> objects
     */
	public ArrayList<Score> getSubComponent() {
		return this.subComponent;
	}
	
	
}
