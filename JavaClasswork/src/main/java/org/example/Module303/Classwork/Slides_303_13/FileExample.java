package org.example.Module303.Classwork.Slides_303_13;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        try {
            // Get the user's home directory
            String userHome = System.getProperty("user.home");
            File outputFile = new File("/Users/hailystevens/2024-RTT-62-Haily/JavaClasswork" + "newfile.txt");

            // Create the file
            if (outputFile.createNewFile()) {
                System.out.println("File created successfully at: " + outputFile.getAbsolutePath());
            } else {
                System.out.println("File already exists at: " + outputFile.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }
}
