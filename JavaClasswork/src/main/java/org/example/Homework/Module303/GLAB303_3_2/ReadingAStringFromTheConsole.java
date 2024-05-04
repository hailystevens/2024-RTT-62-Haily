package org.example.Homework.Module303.GLAB303_3_2;

import java.util.Scanner;

public class ReadingAStringFromTheConsole {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three words separated by spaces: ");
        String s1 = input.next("Hello");
        String s2 = input.next("Java");
        String s3 = input.next("Learners");
        System.out.println("s1 is " + s1);
        System.out.println("s2 is " + s2);
        System.out.println("s3 is " + s3);
    }
}

//Enter three words separated by spaces: Hello Java Learners
//s1 is Hello
//s2 is Java
//s3 is Learners