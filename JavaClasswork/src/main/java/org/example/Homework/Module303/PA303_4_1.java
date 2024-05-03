package org.example.Homework.Module303;

import java.util.Scanner;

//1. Write a program that declares 1 integer variable x, and then assigns 7 to it. Write an if statement to print out “Less than 10” if x is less than 10. Change x to equal 15, and notice the result
public class PA303_4_1 {
    public static void main(String[] args) {
        int x = 10;
        //int x = 15;
        if (x < 10)
            System.out.println("Less than 10");
    }

    //2. Write a program that declares 1 integer variable x, and then assigns 7 to it. Write an if-else statement that prints out “Less than 10” if x is less than 10, and “Greater than 10” if x is greater than 10. Change x to 15 and notice the result.
    public class question2 {
        public static void main(String[] args) {
            int x = 7;
            if (x < 10) {
                System.out.println("Less than 10");
            } else {
                System.out.println("Greater than 10");
            }
        }

        //3. Write a program that declares 1 integer variable x, and then assigns 15 to it. Write an if-else-if statement that prints out “Less than 10” if x is less than 10; “Between 10 and 20” if x is greater than 10 but less than 20, and “Greater than or equal to 20” if x is greater than or equal to 20. Change x to 50 and notice the result.
        public class question3 {
            public static void main(String[] args) {
                int x = 15;
                //int x = 50;
                if (x < 10) {
                    System.out.println("Less than 10");
                } else if (x > 10 && x < 20) {
                    System.out.println("Between 10 and 20");
                } else {
                    System.out.println("Greater than or equal to 20");
                }
            }
        }

        //4. Write a program that declares 1 integer variable x, and then assigns 15 to it. Write an if-else statement that prints “Out of range” if the number is less than 10 or greater than 20 and prints “In range” if the number is between 10 and 20 (including equal to 10 or 20). Change x to 5 and notice the result.
        public class question4 {
            public static void main(String[] args) {
                int x = 15;
                //int x = 5;
                if (x < 10 || x > 20) {
                    System.out.println("Out of range");
                } else {
                    System.out.println("In range");
                }
            }
        }

        //5. Write a program that uses if-else-if statements to print out grades A, B, C, D, F, according to the
// following criteria:
//A: 90-100
//B: 80-89
//C: 70-79
//D: 60-69
//F: <60
//Use the Scanner class to accept a number score from the user to determine the letter grade. Print out “Score out of range” if the score is less than 0 or greater than 100.
        public class question5 {
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


        //6. Write a program that accepts an integer between 1 and 7 from the user. Use a switch statement to print out the corresponding weekday. Print “Out of range” if the number is less than 1 or greater than 7. Do not forget to include “break” statements in each of your cases.
        public class question6 {
            public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                System.out.println("Enter an integer between 1 and 7: ");
                int number = input.nextInt();
                switch (number) {
                    case 1:
                        System.out.println("Sunday");
                        break;
                    case 2:
                        System.out.println("Monday");
                        break;
                    case 3:
                        System.out.println("Tuesday");
                        break;
                    case 4:
                        System.out.println("Wednesday");
                        break;
                    case 5:
                        System.out.println("Thursday");
                        break;
                    case 6:
                        System.out.println("Friday");
                        break;
                    case 7:
                        System.out.println("Saturday");
                        break;
                    default:
                        System.out.println("Out of range");
                }
                ;
            }
        }

//
//7. Create a program that lets the users input their filing status and income.
// Display how much tax the user would have to pay according to status and income.
//The U.S. federal personal income tax is calculated based on the filing status and taxable income.
//There are four filing statuses: Single, Married Filing Jointly, Married Filing Separately, and Head of Household.
//The tax rates for 2009 are shown below.
//https://docs.google.com/document/d/1TqZT1IbtSN7pbgNwZxYdeIPJ8rQMwarKbd-QGrqMVqk/edit
    }
}