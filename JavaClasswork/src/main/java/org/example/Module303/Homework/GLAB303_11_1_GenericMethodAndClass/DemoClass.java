package org.example.Module303.Homework.GLAB303_11_1_GenericMethodAndClass;

public class DemoClass {

    // create a generics method
    public <T> void genericsMethod(T data) {
        System.out.println("Generics Method:");
        System.out.println("Data Passed: " + data);
    }
}

