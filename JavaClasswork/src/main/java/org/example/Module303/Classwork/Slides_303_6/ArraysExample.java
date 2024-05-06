package org.example.Module303.Classwork.Slides_303_6;

import java.util.ArrayList;
import java.util.List;

//make array list variables plural (s)

public class ArraysExample {
    public static void main(String[] args) {

        double[] dArray = new double[10];

        //This is a new way of creating an array. note is on two lines.
        //First creates the variable, Second creates the new array in memory
        int[] iArray;
        iArray = new int[20];


        //this array gets used a bit time to time
        //The compiler will see this and create an array o strings with the size of three values in the array
        String[] constants = {"String1, String1, String3"};
        //new style for loop can be used with arrays
        for (String constant : constants) ;
        {
            System.out.println(constants);
        }


        //this is the same as doing
        String[] c1 = new String[3];
        c1[0] = "String1";
        c1[1] = "String1";
        c1[2] = "String2";


        //this also works for other data types (ON KBA)
        int[] intConstants = {1, 2, 3, 4, 5};
        for (int pos = 0; pos < intConstants.length; pos++) {
            System.out.println(intConstants[pos]);
        }


        //getting the length of an array is simple using .length
        int x = intConstants.length;


        String s = new String("New String");
        s.length(); //will give us the size of the string


        //This is 99% of what you will use in the future
        List<Double> dList = new ArrayList<>();
        dList.size();


        String[] sArray = new String[10];
        String S = new String("New String");
        sArray[0] = S;
    }
}
