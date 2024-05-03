package org.example.Homework.Module303.glab303_3_1.JavaStringMethods;

//compareTo() method:
//The Java String compareTo() method compares the given string with the current string. It is a method of ‘Comparable’ interface that is implemented by the String class. It either returns a positive number, a negative number, or 0. For example:
public class CompareToExample{
public static void main(String args[]){
String s1="hello";
String s2="hello";
String s3="hemlo";
String s4="flag";
System.out.println(s1.compareTo(s2)); // 0 because both are equal
System.out.println(s1.compareTo(s3)); //-1 because "l" is only one time lower than "m"
System.out.println(s1.compareTo(s4)); // 2 because "h" is 2 times greater than "f"
}}
//Java String compares
//We can compare String in Java based on content and reference.
//It is used in authentication (by equals() method), sorting (by compareTo() method), and reference matching (by == operator) etc.
//There are three ways to compare String in Java:
//By Using equals() Method.
//By Using == Operator.
//By compareTo() Method.
//By Using equals() Method
//The String class's equals() method compares the original content of the string. It compares the values of strings for equality.
//Create a class named TestStringComparison and add the code below to it.
//public class TestStringComparison {
//   public static void main(String args[]){
//       String s1="PerScholas";
//       String s2="PerScholas";
//       String s3=new String("PerScholas");
//       String s4="Teksystem";
//       System.out.println(s1.equals(s2));//true
//       System.out.println(s1.equals(s3));//true
//       System.out.println(s1.equals(s4));//false
//   }
//}
//
//Output
//true
//true
//false
//In the above code, two strings are compared to using the equals() method of String class. The result is printed as Boolean values, true or false.
//By Using == operator
//The == operator compares references, not values.
//Create a class named Teststringcomparison2.java and write the code below to it.
//public class Teststringcomparison2 {
//   public static void main(String args[]){
//       String s1="Perscholas";
//       String s2="Perscholas";
//       String s3=new String("Perscholas");
//       System.out.println(s1==s2);//true (because both refer to same instance)
//       System.out.println(s1==s3);//false(because s3 refers to instance created in nonpool)
//   }
//
//}
//
//
//
//Output:
//true
//false
//The above code demonstrates the use of == operator used for comparing two String objects.
//
//
//
//
//By Using compareTo() method,
//The String class's compareTo() method compares values lexicographically. It returns an integer value that describes if the first string is less than, equal to, or greater than the second string.
//// return 0 if this string is the same as another;
//// <0 if lexicographically less than another; or >0
//
//
//Suppose s1 and s2 are two String objects. If:
//s1 == s2 : The method returns 0.
//s1 > s2 : The method returns a positive value.
//s1 < s2 : The method returns a negative value.
//Create a class named Teststringcomparison4.java and write the code below to it.
//public class Teststringcomparison3 {
//   public static void main(String args[]){
//       String s1="Perscholas";
//       String s2="Perscholas";
//       String s3="Perschola";
//       String s4="PerscholasX";
//       System.out.println(s1.compareTo(s2)); //0
//       System.out.println(s1.compareTo(s3)); // 1(because s1>s3)
//       System.out.println(s1.compareTo(s4)); // -1(because s1<s4 )
//   }
//}
//
//Output;
//0
//1
//-1
