package org.example.Module303.Homework.PA303_5_1_Loops;

public class MultiplicationTable {
    public static void main(String[] args) {
        int size = 12; //the size of the table
        for (int r = 1; r <= size; r++) { //loop for rows
            for (int c = 1; c <= size; c++) { //loops for columns
                System.out.printf("%4d", r * c); //formatting
            }
            System.out.println();
        }
    }
}

