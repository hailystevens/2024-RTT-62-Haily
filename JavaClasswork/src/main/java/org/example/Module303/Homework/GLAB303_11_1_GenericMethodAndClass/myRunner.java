package org.example.Module303.Homework.GLAB303_11_1_GenericMethodAndClass;

public class myRunner {
    public static void main(String[] args) {
// initialize the class with Integer data
        DemoClass dObj = new DemoClass();
        dObj.genericsMethod(25); // passing int
        dObj.genericsMethod("Per Scholas"); // passing String
        dObj.genericsMethod(2563.5); // passing float
        dObj.genericsMethod('H'); // passing Char
    }
}


