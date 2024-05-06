package org.example.Module303.Classwork.Slides_303_6;

public class ArrayDelete {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};


        int deletedPosition = 4;
        if ( deletedPosition < 0 || deletedPosition > array.length) {
            System.out.println("position to delete array is invalid");
        }

        // 1- create a new array with 1 less length
        int[] delete = new int[array.length - 1];

        // 2- copy the first part up to but not included the deleted position
        for (int pos = 0; pos < 4; pos++) {
            delete[pos] = array[pos];
        }
        // 3- copy the last elements into a pos-1 in the new array
        for (int pos = deletedPosition + 1; pos < array.length ; pos++) {
            delete[pos - 1] = array[pos];
        }

        for (int value : delete) {
            System.out.println(value);
        }
    }
}