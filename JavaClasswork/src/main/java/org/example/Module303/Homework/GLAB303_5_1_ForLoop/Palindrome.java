package org.example.Module303.Homework.GLAB303_5_1_ForLoop;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        String original, reverse = ""; //objects of String class
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number/string to check if it is a palindrome.");
        original = in.nextLine();
        int length = original.length();
        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + original.charAt(i);
        if (original.equals(reverse)) {
            System.out.println("Entered number/string is a palindrome.");
        } else {
            System.out.println("Entered number/string is not a palindrome.");
        }

    }
}
