package org.example.Module303.Classwork.Slides_303_13;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

    public static void main(String[] args) {

        File output = new File("output.txt");
        try {
            FileWriter fileWriter = new FileWriter(output, true);

            for (int count = 0; count < 10; count++)
            fileWriter.write("Line (" + count + ") I <3 Lurk\n");

            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

