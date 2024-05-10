package org.example.Module303.Classwork.Slides303_9_Inheritance;

public class OuterClass {

    public OuterClass() {
        InnerClass ic = new InnerClass();
    }


    private class InnerClass {
        int x;
        int y;
        int z;
    }


}