package org.example.Homework.Module303.PA303_3_1;

import java.io.*;
import java.util.*;

public class Hackerrank_JavaStringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        String[] arr = s.split("[\\s!,?._'@]+");
        int length = arr.length;

        for (String str : arr) {
            if(str.equals("")) {
                length--;
            }
        }
        System.out.println(length);

        for (String str : arr) {
            if(!str.equals("")) {
                System.out.println(str);
            }
        }

        scan.close();
    }
}
