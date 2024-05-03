package org.example.Homework.Module303.PA303_2_2.CoreJavaTypeCasting;

public class ExplicitTest {
    public static void main(String[] args) {
               double d = 100.04;
               // explicit type casting
               long l = (long)d;
               int i = (int)l;
               System.out.println("Double value "+d);
               System.out.println("Long value "+l);
               System.out.println("Int value "+i);

        byte b;
        int z = 257;
        double dou = 323.142;
        System.out.println("Conversion of int to byte.");
        b = (byte) z;
        System.out.println("z = " + z + " b = " + b);
        System.out.println("Conversion of double to int.");

        z = (int) dou;
        System.out.println("dou = " + dou + " b = " + z);
        System.out.println("Conversion of double to byte.");

        b = (byte) dou;
        System.out.println("dou = " + dou + " b = " + b);

           }
          }





//
//        Output:
//        Double value 100.04
//        Long value 100
//        Int value 100
//        Conversion of int to byte.
//        i = 257 b = 1
//        Conversion of double to int.
//        dou = 323.142 b = 323
//        Conversion of double to byte.
//        dou = 323.142 b = 67



