import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter marks obtained (out of 100) in each subject:");
        System.out.print("Subject 1: ");
        int subject1Marks = scanner.nextInt();

        System.out.print("Subject 2: ");
        int subject2Marks = scanner.nextInt();

        System.out.print("Subject 3: ");
        int subject3Marks = scanner.nextInt();

     
        int totalMarks = subject1Marks + subject2Marks + subject3Marks;

      
        int numberOfSubjects = 3; 
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
