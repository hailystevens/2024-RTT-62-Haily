package org.example.Module303.Homework.PA303_7_1_Arrays;

public class Task7 {
    public static void main(String[] args) {
        //Task 7: Write a program where you create an array of 5 elements.
        // Loop through the array and print the value of each element, except for the middle (index 2) element.
        int[] array = {5, 4, 3, 2, 1};
        for (int i = 0; i < array.length; i++) {
            if (i != 2) {
                System.out.println(i + ": " + array[i]);
            }

        }
    }
}
