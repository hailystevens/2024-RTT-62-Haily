package org.example.Homework.glab303_3_2;
import java.util.Scanner;

    //Guided Lab 303.3.2 - Reading a String From the Console
    //
    //Lab Objective:
    //In this lab, you will demonstrate how to prompt the user to input a string and then read the string from console input.
    //
    //Instructions
    //
    //
    //When you are developing console applications using Java, you must read input from users through the console. To read a string from the console as input in Java applications, you can use the Scanner class along with System.in.
    //Example 1 – Read String from Console Input
    //In this example, we shall define a scanner with the input stream, System.in.
    //System.in creates a standard input stream that is already open and ready to supply input data.
    //The scanner is a simple text scanner that can parse primitive types and strings using regular expressions.
    //So, passing System.in to Scanner allows us to parse or read strings from the standard input stream, which is the console.
    public class ReadingAStringFromTheConsole {
       public static void main(String[] args) {
           Scanner input = new Scanner(System.in);
           System.out.print("Enter three words separated by spaces: ");
           String s1 = input.next();
           String s2 = input.next();
           String s3 = input.next();
           System.out.println("s1 is " + s1);
           System.out.println("s2 is " + s2);
           System.out.println("s3 is " + s3);
       }
    }
    //
    //When the program is run, the execution waits after printing “Enter three words separated by spaces:,” where the user would enter a string similar to “hello world” as shown in the following console window.
    //The program prints the string read from the console input in the next step. The whole output in the console would be as shown in the following.
    //
    //Enter three words separated by spaces: Hello Java Learners
    //s1 is Hello
    //s2 is Java
    //s3 is Learners
    //
    //
    //Example 2: Reading a String From the Console
    //
    //public class ReadingStringFromConsole {
    //   public static void main(String[] args) {
    //
    //       Scanner input = new Scanner(System.in);
    //       System.out.print("Enter a character: ");
    //       String s = input.nextLine();
    //       char ch = s.charAt(0);
    //       System.out.println("The character entered is " + ch);
    //   }
    //}
    //
    //
    //Output
    //
    //Enter a character: Perscholas
    //The character entered is P
    //
    //
    //Reference:
    //https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
    //https://docs.oracle.com/javase/8/docs/api/java/lang/System.html
    //https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#in

