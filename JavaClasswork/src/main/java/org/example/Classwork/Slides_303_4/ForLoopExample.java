package org.example.Classwork.Slides_303_4;

import java.util.ArrayList;
import java.util.List;

public class ForLoopExample {
    public static void main(String[] args) {
        for (int count = 0; count < 10; count++) {
            System.out.println("The count= " + count);

            for (int d = 0; d < 5; d++) {
                System.out.println("The count " + count + " is " + d);
            }
        }
    }
}

class EnhancedLoop {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("First Element");
        stringList.add("Two");
        stringList.add("Three");
        stringList.add("Four");
        stringList.add("Five");

        //we can use an old style loop to move across this list
        for (int pos = 0; pos < stringList.size(); pos++) {
            System.out.println(stringList.get(pos));
        }
        System.out.println("------------------------");

        //nice for new loop
        for (String element : stringList) {
            if (element.equals("Three")) {
                continue;
            }
            System.out.println(element);
        }
    }
}

