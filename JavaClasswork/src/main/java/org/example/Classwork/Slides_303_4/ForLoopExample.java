package org.example.Classwork.Slides_303_4;

public class ForLoopExample {
    public static void main(String[] args) {
        for (int count = 0; count < 10; count++) {
            System.out.println("The count= " + count);

            for (int d = 0; d < 5; d++) {
                System.out.println("The count " + count + " is " + d);
            }
        }
    }
}
