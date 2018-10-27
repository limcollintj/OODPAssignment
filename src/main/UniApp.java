package main;
import java.util.ArrayList;
import java.util.Scanner;

import courses.Course;
import courses.CourseManager;
import students.Student;
import students.StudentManager;

public class UniApp {

	// TODO: Handle All Exceptions
	
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManager();
      
        int choice;

        do {
            showMenu();
            choice = sc.nextInt();
            switchCase(choice);
        } while (choice != 17);
    }

    public static void switchCase(int a) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentManager sm1 = new StudentManager();
        CourseManager cm1 = new CourseManager();
       
        switch(a) {
            case 1:
                //Add new student
                System.out.println("Enter student's name: ");
                String name = sc.next();
                System.out.println("Enter student's matric number: ");
                String matric = sc.next();
                sm1.addNewStudent(name, matric);
                break;

            case 2:
//              // Add course
                System.out.println("Enter course ID: ");
                String courseID = sc.nextLine();
                System.out.println("Enter Maximum Vacancy for the course");
                int maxVacancy = sc.nextInt();
                
                // addProfs() returns an arraylist of profs
                cm1.addNewCourse(courseID, maxVacancy, addProfs());
             
                break;

            case 3:
            	// Register Student for a course
            	
            	
            		System.out.println("Enter Student ID");
                	String studentID = sc.nextLine(); 
                	Student student = sm1.getStudent(studentID);
                	
                	System.out.println("Enter Course ID you want to add student to");
                	courseID = sc.nextLine(); 
                	Course course = cm1.getCourse(courseID);
                	
                	
                	sm1.registerCourse(studentID, course);
                	cm1.registerStudent(student, courseID);
                	
            
            case 4:
            	
                break;

            case 5:
                break;

            case 6:
                // Enter course assessment weightage.
                System.out.println("Enter course ID: ");
//                courseID = sc.next();
//                cm1.editCourseWeightage(cm1.getCourse(courseID));
                break;

            case 7:
                // Enter coursework mark
                break;

            case 8:
                // Enter exam mark

                break;

            case 9:
                break;

            case 10:
                break;
                
            
            case 11: 
            	cm1.printCourses();
            	break;

            case 12: 
            	System.out.println("Enter Student ID");
            
          
            	sm1.printCoursesRegistered(sc.nextLine());
             	break;
            
            
            case 13:

            	sm1.printStudents();
            	break;
              
                
                
            case 14: 
            	System.out.println("Enter Course ID");
            	try {
            		cm1.printStudentsRegisteredInCourse(sc.nextLine());
            	}
            	
            	catch (Exception e){
            		System.out.println(e.getMessage());
            	}
            	
            	break;
            	
            
            case 15: 
            	cm1.resetCourses();
            	break;
            
            case 16: 
            	sm1.resetStudents();
            	break;
            	
            case 17: 
            	  System.out.println("Program terminating.");
                  break;
                  
            case 18: 
            	
          
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
    
    public static ArrayList<String> addProfs() {
    	
    	  Scanner sc = new Scanner(System.in);
    	  System.out.println("Enter Prof Names for the course, enter -1 after the last entry");
          
          ArrayList<String> profNames = new ArrayList<String>(); 
          String profName;
          do {
          	System.out.println("Enter Prof Name");
          	profName = sc.nextLine();
          	if(!profName.equals("-1")) {
          		profNames.add(profName);
          	}
          }
          while(!profName.equals("-1"));
          
          return profNames;
          
    }
    
    
    
    
    
//    public void editCourseWeightage(CourseInfo course) {
//        System.out.println("Enter Exam Weightage (out of 100% course weightage): ");
//        course.exWeightage = sc.nextInt();
//        course.cwWeightage = 100 - course.exWeightage;
//        System.out.println("The coursework weightage (out of 100% coursework weightage) is " + course.cwWeightage);
//        System.out.println("Does the coursework have sub-components?\nY: Yes\nN: no");
//        char in = sc.next().toUpperCase().charAt(0);
//        if (in == 'Y') {
//            course.haveSubComponents = true;
//        }
//        if (course.haveSubComponents) {
//            System.out.println("Enter Assignment weightage (out of 100% coursework weightage): ");
//            course.asWeightage = sc.nextInt();
//            course.cpWeightage = 100 - course.asWeightage;
//            System.out.println("The class participation weightage (out of 100% coursework weightage) is " + course.cpWeightage);
//        }
//        System.out.println("Course Weightage has been edited.");
//    }

}
