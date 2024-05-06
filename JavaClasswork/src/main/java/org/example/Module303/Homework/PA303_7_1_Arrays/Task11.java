package org.example.Module303.Homework.PA303_7_1_Arrays;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        //Task 11: Write some Java code that asks the user how many favorite things they have.
        // Based on their answer, you should create a String array of the correct size.
        // Then ask the user to enter the things and store them in the array you created.
        // Finally, print out the contents of the array.
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many favorite things do you have? ");
        int favoriteThings = scanner.nextInt();
        scanner.nextLine();

        String[] favorites = new String[favoriteThings];

        for (int i = 0; i < favoriteThings; i++) {
            System.out.print("Enter your favorite thing #" + (i + 1) + ": ");
            favorites[i] = scanner.nextLine();
        }

        System.out.println("\nYour favorite things:");
        for (String favorite : favorites) {
            System.out.println(favorite);
        }
    }
}
