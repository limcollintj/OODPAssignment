package lessons;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Lessons implements Serializable{
	protected ArrayList<String> studentIDs;
	protected String profName;
	protected int vacancy;
	
	public Lessons() {
		this.studentIDs= new ArrayList<String>();
	}
	
    public void setprofName(String name) {
    	this.profName = name;
    }
    
    public void addStudent(String id) {
    	this.studentIDs.add(id);
    	this.vacancy--;
    	
    }
    
    public void setStudentIDs(ArrayList<String> studentIDs) {
    	this.studentIDs = studentIDs;
    }
    
    public void setVacancy(int vacancy) {
    	this.vacancy = vacancy;
    }
    
    abstract String getLessonID();
    
    public String getProfName() {
    	return this.profName;
    } 
    
    public ArrayList<String> getstudentIDs() {
    	return this.studentIDs;
    }
    
    public int getVacancy() {
    	return this.vacancy;
    }
    
    abstract void printInfo();
}