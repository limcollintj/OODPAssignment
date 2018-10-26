package lessons;
import java.util.ArrayList;

public interface Lessons {
	
	void setLessonID(String id);
    void setlecturerID(String id);
    void setStudentIDs(String[] studentIDs);
    void setVacancy(int vacancy);
    void printInfo();
    
    String getLessonID(); 
    String getLecturerID(); 
    String getstudentID(); 
    int getVacancy(); 
}


