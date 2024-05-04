package org.example.Module303.Homework.GLAB303_3_1_JavaStringMethods;

public class Trim {
    public static void main(String[] args) {
        String s1 = "  hello   ";
        System.out.println(s1 + "how are you");        // without trim()
        System.out.println(s1.trim() + "how are you"); // with trim()
    }
}

//In the above code, the first print statement will print “hello how are you” while the second statement will print “hello how are you” using the trim() function.