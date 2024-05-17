package org.example.Module303.Homework.PA303_12_1_ExceptionHandling;

import java.util.*;

public class JavaExceptionHandlingTryCatchHackerrank {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        try {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(x / y);
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
        } catch (InputMismatchException e) {
            System.out.println("java.util.InputMismatchException");
        }

        scanner.close();
    }
}


