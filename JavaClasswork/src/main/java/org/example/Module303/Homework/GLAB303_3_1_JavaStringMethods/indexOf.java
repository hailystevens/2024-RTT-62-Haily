package org.example.Module303.Homework.GLAB303_3_1_JavaStringMethods;

public class indexOf {
    public static void main(String[] args) {
        String str1 = "Java is fun";
        int result;

        // getting index of character 's'
        result = str1.indexOf('s');

        System.out.println(result); //6

        //getting index of character 'j'
        result = str1.indexOf('J');
        System.out.println(result); //o
    }
}
