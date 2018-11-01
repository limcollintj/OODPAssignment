package presentation;
import java.util.ArrayList;

import courses.Course;
import courses.CourseManager;
import students.Student;
import students.StudentManager;
import results.Result;
import results.ResultManager;
import util.Scan;

public class UniApp {

	// TODO: Handle All Exceptions
	
    public static void main(String[] args) throws Exception {
      
        int choice,choice1;

        do {
        	System.out.println("Make another action? 1=Yes 2=No");
        	choice = Scan.readInteger();
        	if(choice == 1) {
                showMenu();
                choice = Scan.readInteger();
                switchCase(choice);
                Thread.sleep(1000);
        	}
        	else {
        		System.out.println("Program Terminated.");
        		break;
        	}
        } while (choice != 17);
    }

    public static void switchCase(int a) throws Exception {
       
        switch(a) {
            case 1:
                //Add new student
               AddMethods.addStudent();
                break;

            case 2:
            	// Adds a new course
            	AddMethods.addCourse();
                break;

            case 3:
            	// Registers student for a course
            	RegisterMethods.registerCourse();
            	break;
            
            case 4:	//Check available slot in a course
            	PrintMethods.printVacancy();
                break;

            case 5:	//Print student list for a course
            	PrintMethods.printStudentList();
                break;

            case 6: // Edits the Course Assessment Components Weightage
            	MarksMethods.editCourseWeightage();
                break;

            case 7:
                // Enter coursework mark
            	MarksMethods.enterExamMarks();
                break;

            case 8:
                // prints exam mark
            	PrintMethods.printExamMark();
                break;

            case 9:	//Print course statistics
            	PrintMethods.printCourseStatistics();
                break;

            case 10: //Print student transcript
            	PrintMethods.printStudentTranscript();
                break;
            
            case 11: 
            	// Prints All Available courses
            	PrintMethods.printAllCourses();
            	break;

        
            case 13:
            	
            	// Prints all students registered
            	PrintMethods.printAllStudents();
            	break;
              
                
            case 15: 
            	// Resets all courses
            	ResetMethods.resetCourses();
            	break;
            
            case 16: 
            	// Resets all students
            	ResetMethods.resetStudents();
            	break;
            	
            case 17: 
            	  System.out.println("Program terminating.");
                  break;
                  
          
            	
            default:
                System.out.println("Please enter valid integer choice.");
        }

    }
    

    public static void showMenu() {
        System.out.print(
                "State your choice:\n"+
                        "\t1. Add a student\n" +
                        "\t2. Add a course\n" +
                        "\t3. Register student for a course\n" +
                        "\t4. Check available slot in a class (vacancy in a class)\n" +
                        "\t5. Print student list for a course.\n" +
                        "\t6. Enter Course Assessment Components Weightage\n" +
                        "\t7. Enter coursework mark\n" +
                        "\t8. Enter exam mark\n" +
                        "\t9. Print course statistics\n" +
                        "\t10. Print student transcript\n" +
                        "\t11. Print Courses\n"+
                        "\t12. Print Courses a student has registered in \n"+
                        "\t13. Print All students \n" + 
                        "\t14. Print All students registered in a course\n"+
                        "\t15. Reset Courses\n"+
                        "\t16. Reset Students\n"+
                        "\t17. Terminate Program.\n"+
                        "\t18. Run test function\n"+
                        "\t19. Register a student for a lesson\n" + 
                        "\t20. Print students by lesson\n"
        );
    }
    
   
    
 

}