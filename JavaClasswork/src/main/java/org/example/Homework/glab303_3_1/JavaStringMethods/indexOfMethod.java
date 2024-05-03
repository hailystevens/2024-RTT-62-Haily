package org.example.Homework.glab303_3_1.JavaStringMethods;

public class indexOfMethod {
    // indexOf() method:
    //The indexOf() method returns the index of the first occurrence of the specified character/substring within the string.
    //Example:
    public class findString {
       public static void main(String[] args) {
           String str1 = "Java is fun";
           int result;

           // getting index of character 's'
           result = str1.indexOf('s');

           System.out.println(result); // 6

           // getting index of character 'J'
           result = str1.lastIndexOf('J');
           System.out.println(result); // 0

           // the last occurrence of 'a' is returned
           result = str1.lastIndexOf('a');
           System.out.println(result); // 3

           // character not in the string
           result = str1.lastIndexOf('j');
           System.out.println(result); // -1

           // getting the last occurrence of "ava"
           result = str1.lastIndexOf("ava");
           System.out.println(result); // 1

           // substring not in the string
           result = str1.lastIndexOf("java");
           System.out.println(result); // -1
       }
    }}

    //
    //Output:
    //6
    //0
    //3
    //-1
    //1
    //-1
    //
//contains() method:
//The contains() method checks whether the specified string (sequence of characters) is present in the string or not.
//
//Public class ContainExample {
//  public static void main(String[] args) {
//    String str1 = "Learn Java";
//    Boolean result;
//
//    // check if str1 contains "Java"
//    result = str1.contains("Java");
//    System.out.println(result);  // true
//
//    // check if str1 contains "Python"
//    result = str1.contains("Python");
//    System.out.println(result);  // false
//
//    // check if str1 contains ""
//    result = str1.contains("");
//
//    System.out.println(result);  // true
//  }
//}
//
//
//Output:
//true
//false
//true
//
//
//replace() method
//The replace() method replaces each matching occurrence of the old character/text in the string with the new character/text.
//
//
//The syntax of the replace() method is either:
//stringobj.replace(char oldChar, char newChar)
//or
//stringobj.replace(CharSequence oldText, CharSequence newText)
//Here, stringobj is an object of the String class.
//
//
//Public class ReplaceDemoMain {
//  public static void main(String[] args) {
//    String str1 = "abc cba";
//
//    // all occurrences of 'a' is replaced with 'z'
//    System.out.println(str1.replace('a', 'z'));
//
//    // all occurences of 'L' is replaced with 'J'
//    System.out.println("Lava".replace('L', 'J'));
//    // character not in the string
//    System.out.println("Hello".replace('4', 'J'));
//// all occurrences of "C++" is replaced with "Java"
//    System.out.println(str1.replace("C++", "Java"));
//
//    // all occurences of "aa" is replaced with "zz"
//    System.out.println("aa bb aa zz".replace("aa", "zz"));
//
//    // substring not in the string
//    System.out.println("Java".replace("C++", "C"));
//  }
//}
//
//
//Output
//zbc cbz
//Java
//Hello
//abc cba
//zz bb zz zz
//Java
//
//Note: If the substring to be replaced is not in the string, replace() returns the original string.
//
//Java String replaceAll()
//
//The replaceAll() method replaces each substring that matches the regex of the string with the specified text.
//The syntax of the replaceAll() method is:
//
//string.replaceAll(String regex, String replacement)
//regex - a regex (can be a typical string) that is to be replaced
//replacement - matching substrings are replaced with this string
//Create a class named DemoReplaceAll and add the code below to it.
//public  class DemoReplaceAll {
//  public static void main(String[] args) {
//    String str1 = "Java123is456fun";
//
//    // regex for sequence of digits
//    String regex = "\\d+";
//
//    // replace all occurrences of numeric
//    // digits by a space
//    System.out.println(str1.replaceAll(regex, " "));
//  }
//}
//
//
//
//
//        Output: Java is fun
//
//In the above example, "\\d+" is a regular expression that matches one or more digits.
//
//To learn more about regexes, visit Java Regex.
//
