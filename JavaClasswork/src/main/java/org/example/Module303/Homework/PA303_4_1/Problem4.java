package org.example.Module303.Homework.PA303_4_1;

import java.util.Scanner;

//4. Write a program that declares 1 integer variable x, and then assigns 15 to it. Write an if-else statement that prints “Out of range” if the number is less than 10 or greater than 20 and prints “In range” if the number is between 10 and 20 (including equal to 10 or 20). Change x to 5 and notice the result.
public class Problem4 {
    public static void main(String[] args) {
        int x = 15;
        //int x = 5;
        if (x < 10 || x > 20) {
            System.out.println("Out of range");
        } else {
            System.out.println("In range");
        }
    }
}
