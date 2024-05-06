package org.example.Module303.Homework.PA303_7_1_Arrays;

public class Task5 {
    public static void main(String[] args) {
        //Task 5: Write a program where you create an integer array with a length of 5.
        // Loop through the array and assign the value of the loop control variable (e.g., i)
        // to the corresponding index in the array.
        int[] array = {5, 4, 3, 2, 1};
        for (int i = 0; i < 5; i++) {
        }
        System.out.println(array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Corresponding array index " + i + " is " + array[i] + ".");
        }
    }
}

