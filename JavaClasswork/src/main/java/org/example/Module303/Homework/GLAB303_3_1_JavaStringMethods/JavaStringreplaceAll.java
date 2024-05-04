package org.example.Module303.Homework.GLAB303_3_1_JavaStringMethods;

//The replaceAll() method replaces each substring that matches the regex of the string with the specified text.
//The syntax of the replaceAll() method is:

//string.replaceAll(String regex, String replacement)
//regex - a regex (can be a typical string) that is to be replaced
//replacement - matching substrings are replaced with this string

public class JavaStringreplaceAll {
    public static void main(String[] args) {
        String str1 = "Java123is456fun";

        // regex for sequence of digits
        String regex = "\\d+";

        // replace all occurrences of numeric
        // digits by a space
        System.out.println(str1.replaceAll(regex, " "));
    }
}

//In the above example, "\\d+" is a regular expression that matches one or more digits.
