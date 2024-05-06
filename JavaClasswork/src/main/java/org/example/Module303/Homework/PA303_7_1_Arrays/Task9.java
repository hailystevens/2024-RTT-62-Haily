package org.example.Module303.Homework.PA303_7_1_Arrays;

import java.util.Arrays;

public class Task9 {
    public static void main(String[] args) {
        //Task 9:
        //Write a program to sort the following int array in ascending order: {4, 2, 9, 13, 1, 0}.
        // Print the array in ascending order, and print the smallest and the largest element of the array.
        //The output will look like the following:
        //Array in ascending order: 0, 1, 2, 4, 9, 13
        //The smallest number is 0
        //The biggest number is 13
        int[] array = {4, 2, 9, 13, 1, 0};
        for (int outer = 0; outer < array.length - 1; outer++) {
            for (int pos = 0; pos < array.length - 1; pos++) {
                if (array[pos] > array[pos + 1]) {
                    int temp = array[pos];
                    array[pos] = array[pos + 1];
                    array[pos + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
