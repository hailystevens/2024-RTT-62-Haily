package org.example.Module303.Homework.PA303_5_1_Loops;

public class PredictFutureTuition {
    public static void main(String[] args) {
        double firstYearTuition = 10000;
        double newTuition = firstYearTuition;
        final double percent = .07;
        int year = 0;
        System.out.println("First year tuition is: " + firstYearTuition);
        for (int i = 0; newTuition <= (firstYearTuition * 2); i++) { //loop until the tuition is greater or equal to 20000
            System.out.printf("%-9s", "year: " + (i + 2));
            newTuition = (1 + percent) * newTuition;
            System.out.printf("\ttuition = %.2f%n", newTuition); //formatting
            year++;//increment year
        }
        System.out.println("The tuition will double in: " + year + " years.");
    }
}
