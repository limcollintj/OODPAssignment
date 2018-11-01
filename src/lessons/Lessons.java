package lessons;
import java.util.ArrayList;

public abstract class Lessons {
	protected ArrayList<String> studentIDs;
	protected String profName;
	protected int vacancy;
	
    void setprofName(String name) {
    	this.profName = name;
    }
    
    void addStudent(String id) {
    	this.studentIDs.add(id);
    }
    
    void setStudentIDs(ArrayList<String> studentIDs) {
    	this.studentIDs = studentIDs;
    }
    
    void setVacancy(int vacancy) {
    	this.vacancy = vacancy;
    }
    
    String getProfName() {
    	return this.profName;
    } 
    
    ArrayList<String> getstudentIDs() {
    	return this.studentIDs;
    }
    
    int getVacancy() {
    	return this.vacancy;
    }
}


