package main;
import java.util.ArrayList;
import java.util.Scanner;

import courses.CourseManager;
import students.StudentManager;

public class UniApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManager();
        Object students = sm.retrieveStudents();
        int choice;

        do {
            showMenu();
            choice = sc.nextInt();
            switchCase(choice);
        } while (choice != 11);
    }

    public static void switchCase(int a) {
        Scanner sc = new Scanner(System.in);
        StudentManager sm1 = new StudentManager();
        CourseManager cm1 = new CourseManager();
        String courseID;


        switch(a) {
            case 1:
                //Add new student
                System.out.println("Enter student's name: ");
                String name = sc.next();
                System.out.println(name);
                System.out.println("Enter student's matric number: ");
                String matric = sc.next();
                sm1.addNewStudent(name, matric);
                break;

            case 2:
                //Add course
                System.out.println("Enter course ID: ");
                courseID = sc.nextLine();
                System.out.println("Enter each teaching faculty's ID, separated by a space:");
                String[] lectID = sc.nextLine().split(" ");
                cm1.addNewCourse(courseID, lectID);
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                // Enter course assessment weightage.
                System.out.println("Enter course ID: ");
                courseID = sc.next();
                cm1.editCourseWeightage(cm1.getCourse(courseID));
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
                System.out.println("Program terminating.");

            default:
                System.out.println("Please enter valid integer choice.");
        }

    }


    public static void showMenu() {
        System.out.print(
                "State your choice\n"+
                        "		1. Add a student\n" +
                        "		2. Add a course\n" +
                        "		3. Register student for a course\n" +
                        "		4. Check available slot in a class (vacancy in a class)\n" +
                        "		5. Print student list for a course.\n" +
                        "		6. Enter Course Assessment Components Weightage\n" +
                        "		7. Enter coursework mark\n" +
                        "		8. Enter exam mark\n" +
                        "		9. Print course statistics\n" +
                        "		10. Print student transcript\n" +
                        "       11. Terminate Program.\n"
        );
    }

}
