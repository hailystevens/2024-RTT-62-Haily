package org.example.Module303.Classwork.Slides_303_6;

public class ArrayInsert {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        //original array
        //pos   01234
        //value 12345

        //after inserting
        //pos 01234
        //value 129345

        //lets write some code to insert an element into this array at position 2
        //1- create a new array of size + 1
        int[] insert = new int[array.length + 1];
        //2- copy the firs part of the array (before pos 2) from the old to new one
        for (int pos = 0; pos < 2; pos++) {
            //System.arraycopy(array, 0, insert, 0, 2);
            insert[pos] = array[pos];
        }
        // 3- actually insert the value we want in pos 2
        insert[2] = 9;

        // 4- copy over the rest of the array
        for (int pos = 2; pos < array.length; pos++) {
            insert[pos + 1] = array[pos];
        }

        for (int value : insert) {
            System.out.println(value);
        }
    }
}

