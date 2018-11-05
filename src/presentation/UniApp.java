package presentation;
import util.Scan;


public class UniApp {

	// TODO: Handle All Exceptions
	
    public static void main(String[] args) {
    	try {
        int choice;
        boolean run;
        
        do {
                showMenu();
                choice = Scan.readInteger();
                mainSwitch(choice);
        } while (choice != 3);
        }
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }

    public static void mainSwitch(int a) throws Exception {
        int choice;




        switch(a) {
            case 1:
                do {
                    showStudentMenu();
                    choice = Scan.readInteger();
                    studentSwitch(choice);
                    if (choice == 10) {
                        break;
                    }
                } while (choice != 9);
                break;

            case 2:
                do {
                    showCourseMenu();
                    choice = Scan.readInteger();
                    courseSwitch(choice);
                    if (choice == 11) {
                       break;
                    }
                } while (choice != 10);
                break;

            case 3:
                System.out.println("Program is terminating...");
                break;

            default:
                System.out.println("Please enter a valid integer from 1 - 3.");
        }
       
    }

    public static void studentSwitch(int a) throws Exception {
        switch(a) {
            case 1:
                AddMethods.addStudent();
                break;

            case 2:
                //edit student
                break;

            case 3:
                //remove student
                break;

            case 4:
                RegisterMethods.registerCourse();
                break;

            case 5:
                MarksMethods.enterExamMarks();
                break;

            case 6:
                PrintMethods.printStudentTranscript();
                break;

            case 7:
                PrintMethods.printAllStudents();
                break;

            case 8:
                ResetMethods.resetStudents();
                break;

            case 9:
                System.out.println("Returning to main menu...");
                break;

            case 10:
                System.out.println("Program is terminating...");
                break;

            default:
                System.out.println("Enter a valid integer from 1-10.");
        }
    }

    public static void courseSwitch(int a) throws Exception{
        switch(a) {
            case 1:
                AddMethods.addCourse();
                break;

            case 2:
                //edit course
                break;

            case 3:
                //remove course
                break;

            case 4:
                RegisterMethods.registerCourse();
                break;

            case 5:
                PrintMethods.printStudentList();
                break;

            case 6:
                MarksMethods.editCourseWeightage();
                break;

            case 7:
                PrintMethods.printCourseStatistics();
                break;

            case 8:
                PrintMethods.printAllCourses();
                break;

            case 9:
                ResetMethods.resetCourses();
                break;
            
            case 10:
            	int choice;
            	do {
                showLessonsMenu(); 
                choice = Scan.readInteger();
                
                lessonSwitch(choice);
                if (choice == 6) {
                    break; 
                }
            	} while (choice != 10);
            	showLessonsMenu(); 
            	break;
            	
            	
            case 11:
                System.out.println("Returning to main menu...");
                break;

            case 12:
                System.out.println("Program is terminating...");
                break;

            default:
                System.out.println("Enter a valid integer from 1-11.");
        }
    }
    
    private static void lessonSwitch(int choice) throws Exception {
    	 switch(choice) {
         case 1:
        	// Add Lesson
         	System.out.print("----- Add lesson -----"
         			+ "\nEnter course ID: ");
         	String courseID = Scan.readString();
         	AddMethods.addLesson(courseID);
         	break;
           

         case 2:
             // Register Student to lesson 
        	 AddMethods.addStudentToLesson();
             break;

         case 3:
        	 
         
        	// Print all lessons
         	System.out.print("----- Lesson Details -----"
         			+ "\nEnter Course ID: ");
         	courseID = Scan.readString();
         	PrintMethods.printAllLessons(courseID);
         	break;
         
             
         case 4:
             //Print Student Registered in a lesson 
        	// Lessons Details 
         	System.out.print("----- Lesson Details -----"
         			+ "\nEnter Course ID: ");
         	courseID = Scan.readString();
         	
         	System.out.println("Enter Lesson ID");
         	String lessonID = Scan.readString();
         	PrintMethods.printLesson(courseID, lessonID);
         	
         	break;
         case 5:
            
             break;
    	 }
    }
    
    private static void showMenu() {
        System.out.print(
                "State your Category:\n"+
                        "\t1. Student\n" +
                        "\t2. Courses\n" +
                        "\t3. Exit\n"
        );
    }
    
   private static void showStudentMenu() {
        System.out.print(
                "State your Action:\n" +
                        "\t1. Add Student\n" +
                        "\t2. Edit Student Details\n" +
                        "\t3. Remove Student\n" +
                        "\t4. Register Student for Course\n" +
                        "\t5. Enter Course Results\n" +
                        "\t6. Print Student Transcript\n" +
                        "\t7. Print all students\n" +
                        "\t8. Reset all students\n" +
                        "\t9. Back\n" +
                        "\t10. Exit\n"
        );
   }

    private static void showCourseMenu() {
        System.out.print(
                "State your Action:\n" +
                        "\t1. Add Course\n" +
                        "\t2. Edit Course Details\n" +
                        "\t3. Remove Course\n" +
                        "\t4. Register Student for Course\n" +
                        "\t5. Print Student List for Course\n" +
                        "\t6. Edit Course Weightage\n" +
                        "\t7. Print Course Statistics\n" +
                        "\t8. Print all courses\n" +
                        "\t9. Reset all courses\n" +
                        "\t10. Show Lessons Menu\n"+
                        "\t11. Back\n" +
                        "\t12. Exit\n"
        );
    }
    
    private static void showLessonsMenu() {
    	System.out.print(
                "State your Action:\n" +
                        "\t1. Add Lesson to course\n"+
                        "\t2. Register Student to lesson\n"+
                        "\t3. Print all Lessons for a course\n"+
                        "\t4. Print students registered in a lesson\n"+
                        "\t5. Back\n"+
                        "\t6. Exit\n"
        );	
    }

}

/*
public static void switchCase(int a) throws Exception {
   
    switch(a) {
        case 1:
            //Add new student
        	
           AddMethods.addStudent();
            break;

        case 2:
        	// Adds a new course
//        	DatabaseHandler.updateCourseData(new ArrayList<Course>());
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
        	
        default:
            System.out.println("Please enter valid integer choice.");
    }

}
*/
