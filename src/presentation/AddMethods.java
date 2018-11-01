package presentation;

import java.util.ArrayList;

import courses.CourseManager;
import students.StudentManager;

import util.Scan;

public class AddMethods {
	
	
	public static void addStudent(){
		 System.out.println("Enter student's name: ");
         String name = Scan.readString();
         System.out.println("Enter student's matric number: ");
         String matric = Scan.readString();
         new StudentManager().addNewStudent(name, matric);
	}
	
	public static void addCourse() {
		 // Add course
        System.out.println("Enter course ID: ");
        String courseID = Scan.readString();
        System.out.println("Enter Maximum Vacancy for the course");
        int maxVacancy = Scan.readInteger();
        
        // addProfs() returns an arraylist of profs
        new CourseManager().addNewCourse(courseID, addProfs());
	}
	
	
	 private static ArrayList<String> addProfs() {
	    	
   	  System.out.println("Enter Prof Names for the course, enter -1 after the last entry");
         
         ArrayList<String> profNames = new ArrayList<String>(); 
         String profName;
         do {
         	System.out.println("Enter Prof Name");
         	profName = Scan.readString();
         	if(!profName.equals("-1")) {
         		profNames.add(profName);
         	}
         }
         while(!profName.equals("-1"));
         
         return profNames;
         
   }
	 
	 
	 
}
