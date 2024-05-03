package org.example.Homework.Module303.glab303_2_1;

public class AssignmentOperatorsDemo {
       public static void main(String[] args) {
           //   Assigning Primitive Values
       int j, k;
       j = 10; // j gets the value 10.
       j = 5; // j gets the value 5. The previous value is overwritten.
       k = j; // k gets the value 5.
       System.out.println("j is : " + j);
       System.out.println("k is : " + k);

           //              Multiple Assignments
       k = j = 10; // (k = (j = 10))
       System.out.println("j is : " + j);
       System.out.println("k is : " + k);
       }
    }


    //Output
    //j is : 5
    //k is : 5
    //j is : 10
    //k is : 10
    //
    //

