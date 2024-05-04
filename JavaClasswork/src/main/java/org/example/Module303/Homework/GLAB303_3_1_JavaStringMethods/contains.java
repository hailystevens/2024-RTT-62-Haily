package org.example.Module303.Homework.GLAB303_3_1_JavaStringMethods;

//contains() method:
//The contains() method checks whether the specified string (sequence of characters) is present in the string or not.

public class contains {
    public static void main(String[] args) {
        String str1 = "Learn Java";
        Boolean result;

        // check if str1 contains "Java"
        result = str1.contains("Java");
        System.out.println(result);  // true

        // check if str1 contains "Python"
        result = str1.contains("Python");
        System.out.println(result);  // false

        // check if str1 contains ""
        result = str1.contains("");

        System.out.println(result);  // true
    }
}

