package lessons;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Lessons implements Serializable {
	protected ArrayList<String> studentIDs;
	protected String profName;
	protected int vacancy;
	
	public Lessons() {
		this.studentIDs= new ArrayList<String>();
	}
	
    void setprofName(String name) {
    	this.profName = name;
    }
    
    void addStudent(String id) {
    	this.studentIDs.add(id);
    	this.vacancy--;
    	
    }
    
    void setStudentIDs(ArrayList<String> studentIDs) {
    	this.studentIDs = studentIDs;
    }
    
    void setVacancy(int vacancy) {
    	this.vacancy = vacancy;
    }
    
    abstract String getLessonID();
    
    String getProfName() {
    	return this.profName;
    } 
    
    ArrayList<String> getstudentIDs() {
    	return this.studentIDs;
    }
    
    int getVacancy() {
    	return this.vacancy;
    }
    
    abstract void printInfo();
}


