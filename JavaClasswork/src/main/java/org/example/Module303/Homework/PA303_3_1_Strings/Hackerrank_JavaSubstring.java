package org.example.Module303.Homework.PA303_3_1_Strings;

import java.util.*;

public class Hackerrank_JavaSubstring {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();

        System.out.println(S.substring(start, end));
    }
}

