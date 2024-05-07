package org.example.Module303.Homework.PA303_7_1_Arrays.HomeworkArrays;

import java.util.Random;

public class HomeworkArrays {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        int smallest = array[0];
        int largest = array[0];
        int sum = 0;

        for (int num : array) {
            if (num < smallest) {
                smallest = num;
            }
            if (num > largest) {
                largest = num;
            }
            sum += num;
        }

        double average = (double) sum / array.length;

        System.out.println("Smallest integer in the array: " + smallest);
        System.out.println("Largest integer in the array: " + largest);
        System.out.println("Average integer in the array: " + average);
    }
}
