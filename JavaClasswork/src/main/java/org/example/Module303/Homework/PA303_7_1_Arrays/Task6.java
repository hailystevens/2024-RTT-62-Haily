package org.example.Module303.Homework.PA303_7_1_Arrays;

public class Task6 {
    public static void main(String[] args) {
        //Task 6: Write a program where you create an integer array of 5 numbers.
        // Loop through the array and assign the value of the loop control variable
        // multiplied by 2 to the corresponding index in the array.
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i * 2;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }

    }
}

