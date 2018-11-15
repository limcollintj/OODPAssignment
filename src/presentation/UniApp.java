package presentation;
import students.StudentContainer;
import util.Container;
import util.DataBaseManager;
import util.Scan;


public class UniApp {
	final static String studentDB = "Students.txt";
    // TODO: Handle All Exceptions

    public static void main(String[] args) throws Exception {
        int choice;
        boolean run;
        
        DataBaseManager db = new DataBaseManager();
        
        Container studentContainer = (Container)db.retrieveData(studentDB) == null ? new StudentContainer():(Container)db.retrieveData(studentDB);

        do {
            showMenu();
            System.out.println("Enter your choice: ");
            choice = Scan.readInteger();
            mainSwitch(choice, studentContainer);
        } while (choice != 11);
    }

    public static void showMenu() {
        System.out.println("-------------------------------");
        System.out.println("1) Add New Student");
        System.out.println("2) Register Student For Course");
        System.out.println("3) Print Student List");
        System.out.println("4) Enter Student Result");
        System.out.println("5) Print Student Transcript");
        System.out.println("6) Add New Course");
        System.out.println("7) Edit Course Weightage");
        System.out.println("8) View Course Vacancy");
        System.out.println("9) Print Course Statistics");
        System.out.println("10) Others");
        System.out.println("-------------------------------");
        System.out.println("11) Exit Programme");
        System.out.println("-------------------------------");
    }

    public static void mainSwitch(int a, Container studentContainer) throws Exception {
        int choice;

        switch (a) {
            case 1:
                AddMethods.addStudent(studentContainer);
                DataBaseManager.updateData(studentContainer, studentDB);
                break;
            case 2:
                RegisterMethods.registerCourse();
                break;
            case 3:
                PrintMethods.printAllStudents();
                break;
            case 4:
                MarksMethods.enterExamMarks();
                break;
            case 5:
                PrintMethods.printStudentTranscript();
                break;
            case 6:
                AddMethods.addCourse(studentContainer);	//studentContainer
                break;
            case 7:
                MarksMethods.editCourseWeightage();
                break;
            case 8:
                System.out.print("----- Lesson Details -----"
                        + "\nEnter Course ID: ");
                String courseID = Scan.readString();
                PrintMethods.printAllLessons(courseID);
                break;
            case 9:
                PrintMethods.printCourseStatistics();
                break;
            case 10:
                do{
                    showOthersMenu();
                    choice = Scan.readInteger();
                    switchOthers(choice);
                    if (choice == 6){
                        break;
                    }
                }while (choice !=6);
                break;
            case 11:
                System.out.println("Programme Terminating...");
                break;
        }
    }

    private static void showOthersMenu() {
        System.out.print(
                "Others:\n" +
                        "\t1) Remove Student\n" +
                        "\t2) Remove Course\n" +
                        "\t3) Reset All Students\n" +
                        "\t4) Reset All Course\n" +
                        "\t5) Back\n" +
                        "\t6) Exit\n"
        );
    }

    private static void switchOthers(int a) throws Exception {
        switch (a){
            case 1:
                //remove student
                break;
            case 2:
                //remove course
                break;
            case 3:
                ResetMethods.resetStudents();
                break;
            case 4:
                ResetMethods.resetCourses();
                break;
            case 5:
                System.out.println("Returning to main menu...");
                break;
            case 6:
                System.out.println("Programme Terminating...");
                break;
        }
    }
}


        /*switch(a) {
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
    */
        /*
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

            default:
                System.out.println("Please enter valid integer choice.");
        }

    }
*/

