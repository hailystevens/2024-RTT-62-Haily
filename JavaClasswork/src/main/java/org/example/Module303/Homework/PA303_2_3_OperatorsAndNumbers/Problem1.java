package org.example.Module303.Homework.PA303_2_3_OperatorsAndNumbers;

//Write a program that declares an integer a variable x, assigns the value 2 to it, and prints out
// the binary string version of the number ( Integer.toBinaryString(x) ). Now, use the left shift
// operator (<<) to shift by 1 and assign the result to x. Before printing the results, write a
// comment with the predicted decimal value and binary string. Now, print out x in decimal form and
// in binary notation.
public class Problem1 {
    public static void main(String[] args) {

        int x = 2;
        System.out.println("The binary version off the number is " + Integer.toBinaryString(x));
        x = x << 1; // i predict 0.2
        System.out.println("Value of x after left shift by 1: " + x);
        System.out.println("Binary representation of x after left shift by 1: " + Integer.toBinaryString(x));

        int y = 9;
        y = y << 1;
        System.out.println("Value of y after left shift by 1: " + y);
        System.out.println("Binary representation of y after left shift by 1: " + Integer.toBinaryString(y));

        int z = 17;
        z = z << 1;
        System.out.println("Value of z after left shift by 1: " + z);
        System.out.println("Binary representation of z after left shift by 1: " + Integer.toBinaryString(z));

        int w = 88;
        w = w << 1;
        System.out.println("Value of w after left shift by 1: " + w);
        System.out.println("Binary representation of w after left shift by 1: " + Integer.toBinaryString(w));
    }
}
