package org.example.Module303.Homework.GLAB303_10_1_InheritanceAndObjectTypeCasting;

public class Boy extends Person {
    static double ageFactor = 1.1;

    public static double lifeSpan() {
        return 0;
    }

    public String talk() {
        return (super.talk() + " ... but I love Java class.");
    }

    public String walk() {
        return ("I am now walking");
    }
}
