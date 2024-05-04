package org.example.Module303.Homework.PA303_4_1_ControlFlow_Conditional_Statements;

import java.util.Scanner;

//5. Write a program that uses if-else-if statements to print out grades A, B, C, D, F, according to the
// following criteria:
//A: 90-100
//B: 80-89
//C: 70-79
//D: 60-69
//F: <60
//Use the Scanner class to accept a number score from the user to determine the letter grade. Print out “Score out of range” if the score is less than 0 or greater than 100.
public class Problem5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number score: ");
        int score = input.nextInt();
        input.close();
        if (score < 0 || score > 100) {
            System.out.println("Score out of range");
        } else if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
