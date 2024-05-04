package org.example.Module303.Homework.GLAB303_5_2_WhileLoop;

import java.util.Scanner;

public class AnAdvancedMathTool {
    public static void main(String[] args) {
        final int NUMBER_OF_QUESTIONS = 5; //number of questions
        int correctCount = 0; //count the number of correct answers
        int count = 0; //count the number of questions
        long startTime = System.currentTimeMillis();
        String output = ""; // output string is initially empty
        Scanner input = new Scanner(System.in);

        while (count < NUMBER_OF_QUESTIONS) {
            //generate two random single digit numbers
            int number1 = (int) (Math.random());
            int number2 = (int) (Math.random());
//if number1 < number2, swap number1 with number2
            if (number1 < number2) {
                int temp = number1;
                number1 = number2;
                number2 = temp;
            }
            //prompt the student to answer "what is number1 - number2?"
            System.out.println(
                    "what is " + number1 + " - " + number2 + " ? ");
            int answer = input.nextInt();
            //grade the answer nd display the result
            if (number1 - number2 == answer) {
                System.out.println("You are correct!");
                correctCount++;
            } else
                System.out.println("Your answer is wrong.\n" + number1 + " should be " + (number1 - number2));
            //increase the count
            count++;
            output += "\n" + number1 + " - " + number2 + " = " + answer + ((number1 - number2 == answer) ? " correct " : " wrong ");
        }
    }


}

