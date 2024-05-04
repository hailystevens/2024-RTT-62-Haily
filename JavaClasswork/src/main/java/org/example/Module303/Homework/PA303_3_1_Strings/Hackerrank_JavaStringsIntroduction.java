package org.example.Module303.Homework.PA303_3_1_Strings;

import java.util.*;

public class Hackerrank_JavaStringsIntroduction {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();

        int a_lentgh =A.length();
        int b_lentgh =B.length();
        System.out.println(a_lentgh + b_lentgh);

        int result = A.compareTo(B);

        if (result > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1) + " " +
                B.substring(0, 1).toUpperCase() + B.substring(1));
    }
}

