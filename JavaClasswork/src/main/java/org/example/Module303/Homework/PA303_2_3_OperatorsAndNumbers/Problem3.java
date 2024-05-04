package org.example.Module303.Homework.PA303_2_3_OperatorsAndNumbers;

//Write a program that declares a variable x, and assigns 150 to it, and prints out the binary
// string version of the number. Now use the right shift operator (>>) to shift by 2 and assign
// the result to x. Write a comment indicating what you anticipate the decimal and binary values to be.
// Now print the value of x and the binary string.

public class Problem3 {
    public static void main(String[] args) {

        int varX = 150;
        System.out.println("The binary version of the number is " + Integer.toBinaryString(varX));
        varX = varX >> 2; // 6
        System.out.println("Value of x after right shift by s: " + varX);
        System.out.println("Binary representation of x after right shift by 2: " + Integer.toBinaryString(varX));

        //225
        int varY = 225;
        varY = varY >> 2;
        System.out.println("Value of varY after right shift by 2: " + varY);
        System.out.println("Binary representation of varY after right shift by 2: " + Integer.toBinaryString(varY));

        //1555
        int varW = 1555;
        varW = varW >> 2;
        System.out.println("Value of varW after right shift by 2: " + varW);
        System.out.println("Binary representation of varW after right shift by 2: " + Integer.toBinaryString(varW));

        //32456
        int varZ = 32456;
        varZ = varZ >> 2;
        System.out.println("Value of varZ after right shift by 2: " + varZ);
        System.out.println("Binary representation of varZ after right shift by 2: " + Integer.toBinaryString(varZ));

    }
}