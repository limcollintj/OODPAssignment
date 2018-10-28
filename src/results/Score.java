package results;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.Serializable;

public abstract class Score  implements Serializable{

    private final String NAME;
	private ArrayList<Score> subComponent = new ArrayList<Score>();
    private double maxMark = 100;
    private double mark = 0;

    public Score(String name) {
    	this.NAME = name;
    	}
    
    public double getMark(){
    	return this.mark;
    }
    
    public void setMark(double mark) {
    	if(mark < 0) {
    		throw new IllegalArgumentException("Mark must be >= 0");
    	}
    	if(mark > maxMark) {
    		throw new IllegalArgumentException("Mark cannot be greater than max. mark.");
    	}
    	this.mark = mark;
    }
    
    public double getMaxMark() {
    	return this.maxMark;
    }
    
    public void setMaxMark(int mark) {
    	if(mark <= 0) {
    		throw new IllegalArgumentException("Max mark must be > 0.");
    	}
    	this.maxMark = mark;
    }
    
    public String getName() {
    	return this.NAME;
    }
    
    public void addSubComponent(Score score){
		subComponent.add(score);
	}
	
	public ArrayList<Score> getSubComponent() {
		return this.subComponent;
	}
}
