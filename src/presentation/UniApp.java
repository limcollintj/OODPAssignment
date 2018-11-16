package presentation;

import util.Scan;


public class UniApp {
	final static String studentDB = "Students.txt";
	final static String courseDB = "Courses.txt";
  
	//Main
    public static void main(String[] args){
        int choice;

        //Loops until the user request to exit
        do {
        	System.out.println("");
            showMenu();
            System.out.println("\nEnter your choice: ");
            choice = Scan.readInteger();
            mainSwitch(choice);
        } while (choice != 12);

    }

    /**
     * Shows the main menu for the application
     * @param args
     */
    private static void showMenu() {
        System.out.println("----------- Students ------------");
        System.out.println("1) Add New Student");
        System.out.println("2) Register Student For Course");
        System.out.println("3) Print Student List");
        System.out.println("4) Enter Student Result");
        System.out.println("5) Print Student Transcript\n");
        
        System.out.println("----------- Courses --------------");
        System.out.println("6) Add New Course");
        System.out.println("7) Edit Course Weightage");
        System.out.println("8) View Course Information");
        System.out.println("9) Print Course Statistics");
        System.out.println("10) Print All Courses\n");
        System.out.println("----------- Others ---------------");
        System.out.println("11) Others");
        System.out.println("----------------------------------");
        System.out.println("12) Exit Programme");
        System.out.println("----------------------------------");
    }

    /**
     * Logic for the main application
     * @param a
     */
    private static void mainSwitch(int a) {
        int choice;

        switch (a) {
            case 1:
                AddMethods.addStudent();
                break;
            case 2:
                RegisterMethods.registerCourse();
                break;
            case 3:
            	 do{
                     showStudentListMenu();
                     choice = Scan.readInteger();
                     switchStudentList(choice);
                     if (choice == 4){
                         break;
                     }
                 }while (choice !=5);
                 break;
               
            case 4:
                MarksMethods.enterExamMarks();
                break;
            case 5:
                PrintMethods.printStudentTranscript();
                break;
            case 6:
                AddMethods.addCourse();	
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
            	PrintMethods.printAllCourses();
            	break;
            case 11:
                do{
                    showOthersMenu();
                    choice = Scan.readInteger();
                    switchOthers(choice);
                    if (choice == 4){
                        break;
                    }
                }while (choice !=4);
                break;
            case 12:
                System.out.println("Programme Terminating...");
                break;
                
            
        }
    }
    
    
    
    /**	
     * Shows the Student List menu to the user
     */
    private static void showStudentListMenu() {
    	System.out.print(
                "Print Students list:\n" +
                        "\t1) Print All Students\n" +
                        "\t2) Print Students Registered in Course\n" +
                        "\t3) Prints Students Registered in a Lesson\n" +
                        "\t4) Back\n" +
                        "\t5) Terminate Program"
        );
    }
    
    /**
     * Logic for student menu 
     * @param a
     */
    private static void switchStudentList(int a) {
    	
    	switch(a) {
	    	case 1: 
	    		 PrintMethods.printAllStudents();
	             break;
	             
	    	case 2: 
	    		 PrintMethods.printStudentList();  
	    		 break;
	    		 
	    	case 3: 
	    		 PrintMethods.printLesson();
	    		 break;
	    	case 4:
	             System.out.println("Returning to main menu...");
	             break;
	        case 5:
	            System.out.println("Programme Terminating...");
	            break;
    	}
    }
    

   /**
    * Shows the Other information menu 
    */
	private static void showOthersMenu() {
        System.out.print(
                "Others:\n" +
                       
                        "\t1) Reset All Students\n" +
                        "\t2) Reset All Course\n" +
                        "\t3) Back\n" +
                        "\t4) Exit\n"
        );
    }

	/**
	 * Logic for Other's menu
	 * @param a
	 */
    private static void switchOthers(int a){
        switch (a){
       
            case 1:
                ResetMethods.resetStudents();
                break;
            case 2:
                ResetMethods.resetCourses();
                break;
            case 3:
                System.out.println("Returning to main menu...");
                break;
            case 4:
                System.out.println("Programme Terminating...");
                break;
        }
    }
}

