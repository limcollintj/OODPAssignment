package presentation;
import java.util.ArrayList;

import courses.Course;
import courses.CourseManager;
import students.Student;
import students.StudentManager;
import results.Result;
import results.ResultManager;
import util.DatabaseHandler;
import util.Scan;

public class UniApp {

	// TODO: Handle All Exceptions
	
    public static void main(String[] args) throws Exception {
      
        int choice,choice1;

        do {
        	
                showMenu();
                choice = Scan.readInteger();
                switchCase(choice);
             
        } while (choice != 100);
    }

    public static void switchCase(int a) throws Exception {
       
        switch(a) {
            case 1:
                //Add new student
            	
               AddMethods.addStudent();
                break;

            case 2:
            	// Adds a new course
//            	DatabaseHandler.updateCourseData(new ArrayList<Course>());
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

        
            case 12:
            	// Prints all students registered
            	PrintMethods.printAllStudents();
            	break;
              
                
            case 13: 
            	// Resets all courses
            	ResetMethods.resetCourses();
            	break;
            
            case 14: 
            	// Resets all students
            	ResetMethods.resetStudents();
            	break;
        
            case 15:
            	// Add Lesson
            	System.out.print("----- Add lesson -----"
            			+ "\nEnter course ID: ");
            	String courseID = Scan.readString();
            	AddMethods.addLesson(courseID);
            	break;
            case 16:
            	// Print all lessons
            	System.out.print("----- Lesson Details -----"
            			+ "\nEnter Course ID: ");
            	courseID = Scan.readString();
            	PrintMethods.printAllLessons(courseID);
            	break;
            	
            case 17: 
            	// Lessons Details 
            	System.out.print("----- Lesson Details -----"
            			+ "\nEnter Course ID: ");
            	courseID = Scan.readString();
            	
            	System.out.println("Enter Lesson ID");
            	String lessonID = Scan.readString();
            	PrintMethods.printLesson(courseID, lessonID);
            	break;
            	
            case 18: 
            	AddMethods.addStudentToLesson();
            	break;
            
            case 19: 
            	DatabaseHandler.updateResultData(new ArrayList<Result>());
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
                        "\t11. Print All Courses\n"+
                        "\t12. Print All students \n" + 
                        "\t13. Reset Courses\n"+
                        "\t14. Reset Students\n"+
                        "\t15. Add Lesson\n"+
                        "\t16. Print All Lessons \n"+
                        "\t17. Lesson Details\n"+
                        "\t18. Add Student to Lesson\n" 
                        
        );
    }
    
   
    
 

}
