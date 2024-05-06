package org.example.Module303.Homework.PA303_7_1_Arrays;

public class Task8 {
    public static void main(String[] args) {
        //Task 8: Write a program that creates a String array of 5 elements and
        // swaps the first element with the middle element without creating a new array.
        String[] array = {"H","A","I","L","Y"};
        int middleElement = array.length / 2;
        String temp = array[0];
        array[0] = array[middleElement];
        array[middleElement] = temp;

        for (String element : array) {
            System.out.print(element + " ");
        }
    }
}