package org.example.Module303.Classwork.Slides_303_6;

public class SmallestValue {
    public static void main(String[] args) {
        int[] myarray = {0, 2, 4, 6, 8, 10};

        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < myarray.length; i++) {
            if (myarray[i] < minVal) {
                minVal = myarray[i];
            }
        }
        System.out.println("minVal = " + minVal);
    }
}


