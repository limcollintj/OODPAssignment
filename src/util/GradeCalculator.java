package util;

import java.util.ArrayList;

public class GradeCalculator {
    /**
     * Calculates GPA
     * @param gradeList List of grades
     * @return GPA
     */
    public static double calGPA(ArrayList<String> gradeList){
        double totalGPA=0;
        double GPA=0;
        for(int i = 0; i < gradeList.size() ; i++){
            switch (gradeList.get(i).toString()){
                case "A+":
                case "A":
                    GPA = 5;
                    break;
                case "A-":
                    GPA = 4.5;
                    break;
                case "B+":
                    GPA = 4.0;
                    break;
                case "B":
                    GPA = 3.5;
                    break;
                case "B-":
                    GPA = 3.0;
                    break;
                case "C+":
                    GPA = 2.5;
                    break;
                case "C":
                    GPA = 2;
                    break;
                case "F":
                    GPA = 1;
                    break;
            }
            totalGPA += GPA;
        }
        GPA = totalGPA/(gradeList.size());
        return GPA;
    }

    /**
     * Calculates Grade
     * @param d score
     * @return Alphabetical Grade
     */
    
        public static String calGrades(double d){
            int scoreMod = (int) d/10;
            String grade;
            switch (scoreMod){
                default:
                    grade = "F";
                    break;
                case 10:
                case 9:
                    grade = "A+";
                    break;
                case 8:
                    if((d-scoreMod*10)>4){
                        grade = "A+";
                    } else{
                        grade = "A";
                    }
                    break;
                case 7:
                    if((d-scoreMod*10)>4){
                        grade = "A-";
                    } else{
                        grade = "B+";
                    }
                    break;
                case 6:
                    if((d-scoreMod*10)>4){
                        grade = "B";
                    } else{
                        grade = "B-";
                    }
                    break;
                case 5:
                    if((d-scoreMod*10)>4){
                        grade = "C+";
                    } else {
                        grade = "C";
                    }
                    break;
            }
            return grade;
        }
    

}



