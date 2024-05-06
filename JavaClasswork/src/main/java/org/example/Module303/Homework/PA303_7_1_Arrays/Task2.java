package org.example.Module303.Homework.PA303_7_1_Arrays;

public class Task2 {
    public static void main(String[] args) {
        //Task 2: Write a program that returns the middle element in an array.
        // Give the following values to the integer array: {13, 5, 7, 68, 2} and produce the following output: 7
        int[] array = {13, 5, 7, 68, 2};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 7) {
                System.out.println(array[i]);

            }
        }
    }
}