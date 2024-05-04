package org.example.Module303.Homework.GLAB303_5_1_ForLoop;

public class Pyramid {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.println("* ");
            }
            System.out.println(); //new line
        }
    }
}
