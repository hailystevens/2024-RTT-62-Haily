package org.example.Homework.Module303.GLAB303_3_2;

import java.util.Scanner;

public class ReadStringFromConsoleInput {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a character: ");
        String s = input.nextLine();
        char ch = s.charAt(0);
        System.out.println("The character entered is " + ch);
    }
}
