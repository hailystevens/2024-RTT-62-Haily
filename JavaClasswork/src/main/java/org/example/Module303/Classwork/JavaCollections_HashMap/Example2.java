package org.example.Module303.Classwork.JavaCollections_HashMap;
//2. Write a Java program to count the number of key-value (size) mappings in a map.

import java.util.*;

class Example2 {
    public static void main(String args[]) {
        // Creating a HashMap
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();

        // Associating values with keys
        hash_map.put(1, "Red");
        hash_map.put(2, "Green");
        hash_map.put(3, "Black");
        hash_map.put(4, "White");
        hash_map.put(5, "Blue");

        // Counting the number of key-value mappings
        int size = hash_map.size();
        System.out.println("Size of the hash map: " + size);
    }
}
