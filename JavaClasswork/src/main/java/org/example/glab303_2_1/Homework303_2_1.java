package org.example.glab303_2_1;


public class Homework303_2_1 {
    public static void main(String[] args) {

        //Write a program that declares two integer variables, assigns an integer to each,
        // and adds them together. Assign the sum to a variable. Print out the result.
        int num1 = 10;
        int num2 = 20;

        int sum = num1 + num2;

        System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum);

        //Write a program that declares two double variables, assigns a number to each,
        // and adds them together. Assign the sum to a variable. Print out the result.
        double d1 = 10.5d;
        double d2 = 30.5d;

        double dSum = d1 + d2;

        System.out.println("The sum of " + d1 + " and " + d2 + " is " + dSum);

        //Write a program that declares an integer variable and a double variable, assigns
        // numbers to each, and adds them together. Assign the sum to a variable. Print out
        // the result. What variable type must the sum be?
        int x = 30;
        double y = 50.55;

        double sum3 = x + y;

        System.out.println("The sum of " + x + " and " + y + " is " + sum3);

        //Write a program that declares two integer variables, assigns an integer to each, and
        // divides the larger number by the smaller number. Assign the result to a variable.
        // Print out the result. Now change the larger number to a decimal. What happens?
        // What corrections are needed?
        int v1 = 80;
        int v2 = 50;
        double div = (double) v1 / (double) v2;
        System.out.println("The quotient of " + v1 + " and " + v2 + " is " + div);

        //Write a program that declares two double variables, assigns a number to each, and divides
        // the larger by the smaller number. Assign the result to a variable. Print out the result.
        // Now, cast the result to an integer. Print out the result again.
        double var1 = 100;
        double var2 = 20;
        double divide = (double) var1 / (double) var2;
        System.out.println("The quotient of " + var1 + " and " + var2 + " is " + divide);
        double result = 5;
        int newInt = (int) result;
        System.out.println("The integer result is " + newInt);

        //Write a program that declares two integer variables, x and y, and assigns the number 5
        // to x and the number 6 to y. Declare a variable q and assign y/x to it and print q.
        // Now, cast y to a double and assign it to q. Print q again.
        int X, Y;
        X = 5;
        Y = 6;
        int q = Y / X;
        System.out.println("The integer value of X/Y is " + q);
        double newY = (Y);
        newY = q;
        System.out.println("The double value of " + q + " is " + newY);

        //Write a program that declares a named constant and uses it in a calculation. Print the result.
        int f = 12;
        int p = 4;
        int NUMBER_OF_FLOWERS = f;
        int NUMBER_OF_BOUQUETS = p;
        int TOTAL_FLOWERS = f * p;
        System.out.println("I have " + TOTAL_FLOWERS + " flowers");

        //Write a program where you create three variables that represent products at a cafe.
        // The products could be beverages like coffee, cappuccino, espresso, green tea, etc.
        // Assign prices to each product. Create two more variables called subtotal and totalSale
        // and complete an “order” for three items of the first product, four items of the second
        // product, and two items of the third product. Add them all together to calculate the subtotal.
        // Create a constant called SALES_TAX and add sales tax to the subtotal to obtain the totalSale
        // amount. Be sure to format the results to two decimal places.
        double coffeePrice = 5.0;
        double cappuccinoPrice = 6.0;
        double espressoPrice = 2.5;
        int coffeeQuantity = 3;
        int cappuccinoQuantity = 4;
        int espressoQuantity = 2;
        double subTotal = (coffeePrice * coffeeQuantity) + (cappuccinoPrice * cappuccinoQuantity) + (espressoPrice * espressoQuantity);
        double SALES_TAX = 0.053 * subTotal;
        double totalSale = subTotal + SALES_TAX;
        totalSale = Math.round(totalSale * 100.0) / 100.0; //I found this 0.00 solution online not on my own
        System.out.println("The total cost is $" + totalSale);
        //find out how to format decimal
    }
}
//Terminal Output
//The sum of 10.5 and 30.5 is 41.0
//The sum of 30 and 50.55 is 80.55
//The quotient of 80 and 50 is 1.6
//The quotient of 100.0 and 20.0 is 5.0
//The integer result is 5
//The integer value of X/Y is 1
//The double value of 1 is 1.0
//I have 48 flowers
//The total cost is $46.33