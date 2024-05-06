package org.example.Module303.Classwork.Slides_303_6;

import java.util.Arrays;

public class ArraySort {

    public static void main(String[] args) {

        int[] array = {6, 0, 3, 5, 1, 10, 20, -1};

        for (int outer = 0; outer < array.length -1; outer++) {
            for (int pos = 0; pos < array.length -1; pos++) {
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