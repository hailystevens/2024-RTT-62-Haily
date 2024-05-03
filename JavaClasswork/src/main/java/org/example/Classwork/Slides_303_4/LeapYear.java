package org.example.Classwork.Slides_303_4;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year = scanner.nextInt();

        boolean isLeapYear = false;
        if ((year % 4 == 0) && (year % 100 > 0)) {
            isLeapYear = true;
        } else if (year % 400 == 0) {
            isLeapYear = true;
        }
        System.out.println(year + " Is a leap year: " + isLeapYear);
    }
}
