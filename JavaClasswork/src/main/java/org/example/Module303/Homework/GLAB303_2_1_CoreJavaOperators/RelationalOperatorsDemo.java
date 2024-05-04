package org.example.Module303.Homework.GLAB303_2_1_CoreJavaOperators;

public class RelationalOperatorsDemo {
       public static void main(String[] args)
       {
           int x = 10, y = 5;
           System.out.println("x > y : "+(x > y));
           System.out.println("x < y : "+(x < y));
           System.out.println("x >= y : "+(x >= y));
           System.out.println("x <= y : "+(x <= y));
           System.out.println("x == y : "+(x == y));
           System.out.println("x != y : "+(x != y));

           int variable1 = 50, variable2 = 100, variable3 = 50;
           System.out.println("variable1 = " + variable1);
           System.out.println("variable2 = " + variable2);
           System.out.println("variable3 = " + variable3);
           System.out.println("variable1 == variable2: "
                   + (variable1 == variable2));

           System.out.println("variable1 == variable3: "
                   + (variable1 == variable3));
       }
    }


    //Output
    //x > y : true
    //x < y : false
    //x >= y : true
    //x <= y : false
    //x == y : false
    //x != y : true
    //variable1 = 50
    //variable2 = 100
    //variable3 = 50
    //variable1 == variable2: false
    //variable1 == variable3: true
    //
    //

