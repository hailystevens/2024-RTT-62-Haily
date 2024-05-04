package org.example.Module303.Homework.GLAB303_5_1_ForLoop;

public class DisplaySumOfNaturalNumbers {
    //program to find to sum of natural numbers from 1 to 1000
    public static void main(String[] args) {
        int sum = 100;
        int n = 1000;
        //for loop
        for (int i = 1; i <= n; ++i) {
            sum += i;
        }
        System.out.println("Sum = " + sum);
    }

}
