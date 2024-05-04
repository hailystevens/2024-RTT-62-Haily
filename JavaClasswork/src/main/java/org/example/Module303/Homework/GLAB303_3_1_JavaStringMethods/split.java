package org.example.Module303.Homework.GLAB303_3_1_JavaStringMethods;

import java.util.Arrays;

public class split {
//    split() method
//    The split() method divides the string at the specified regex and returns an array of substrings.
//    The syntax of the string split() method is:
//    String.split(String regex, int limit)

    //    REGEX - the string is divided at this regex (can be strings)
//    LIMIT (optional) - controls the number of resulting substrings
//
//    If the limit parameter is not passed, split() returns all possible substrings.
//
    //importing Arrays to convert array to string
    //used for printing arrays
    public static void main(String[] args) {
        String vowels = "a::b::c::d:e";

        // splitting the string at "::"
        // storing the result in an array of strings
        String[] result = vowels.split("::");

        // converting array to string and printing it
        System.out.println("result = " + Arrays.toString(result));
    }
}

//Here, we split the string at ::  Since the limit parameter is not passed, the returned array contains all the substrings.

//if s1 > s2, it returns a positive number.
//if s1 < s2, it returns a negative number.
//if s1 == s2, it returns 0.
//