package org.example.Module303.Classwork.Slides_303_6;

import java.util.Arrays;
import java.util.Scanner;

class ArrayDelete {
    public static Scanner scanner = new Scanner(System.in);
    static String[] arr = {"A", "B", "C", "D", "E", "F"};
    public static void main(String[] args) {
        System.out.println("Enter the position of the item to delete: ");
        int position = scanner.nextInt();
        delete(arr,position);
    }

    public static void delete(String[] source, int atPos) {
        String[] array = source;
        String[] newArray = new String[array.length - 1];
        if (atPos > array.length - 1 || atPos < 0) {
            System.out.println("Position is out of bounds");
            return;
        }
        System.out.println("Ok, we are deleting " + array[atPos] + "!");
        for (int i = 0; i < newArray.length; i++) {
            if (i < atPos) {
                newArray[i] = array[i];
            } else {
                newArray[i] = array[i + 1];
            }
        }
        System.out.println("Changing Array from: " + Arrays.toString(array));
        System.out.println("To: " + Arrays.toString(newArray));
    }
}