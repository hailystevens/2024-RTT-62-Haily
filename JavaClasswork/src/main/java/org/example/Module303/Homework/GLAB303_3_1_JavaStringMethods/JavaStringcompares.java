package org.example.Module303.Homework.GLAB303_3_1_JavaStringMethods;

//We can compare String in Java based on content and reference.
//It is used in authentication (by equals() method), sorting (by compareTo() method), and reference matching (by == operator) etc.
//There are three ways to compare String in Java:

//By Using equals() Method.

//By Using == Operator.

//By compareTo() Method.

//The String class's equals() method compares the original content of the string. It compares the values of strings for equality.


//equals() method:
public class JavaStringcompares {
    public static void main(String args[]) {
        String s1 = "PerScholas";
        String s2 = "PerScholas";
        String s3 = new String("PerScholas");
        String s4 = "Teksystem";
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//true
        System.out.println(s1.equals(s4));//false
    }
//In the above code, two strings are compared to using the equals() method of String class. The result is printed as Boolean values, true or false.

    // By using == operator
    public void equalsopertor() {
        String s1 = "PerScholas";
        String s2 = "PerScholas";
        String s3 = new String("PerScholas");
        String s4 = "Teksystem";
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//true
        System.out.println(s1.equals(s4));//false
    }
//In the above code, two strings are compared to using the equals() method of String class. The result is printed as Boolean values, true or false.

//By Using compareTo() method,

//The String class's compareTo() method compares values lexicographically.
// It returns an integer value that describes if the first string is less than, equal to, or greater than the second string.
    // return 0 if this string is the same as another;
    // <0 if lexicographically less than another; or >0


    //Suppose s1 and s2 are two String objects. If:
    //s1 == s2 : The method returns 0.
    //s1 > s2 : The method returns a positive value.
    //s1 < s2 : The method returns a negative value.
    public void compareTo() {
        String s1 = "Perscholas";
        String s2 = "Perscholas";
        String s3 = "Perschola";
        String s4 = "PerscholasX";
        System.out.println(s1.compareTo(s2)); //0
        System.out.println(s1.compareTo(s3)); // 1(because s1>s3)
        System.out.println(s1.compareTo(s4)); // -1(because s1<s4 )
    }
}
