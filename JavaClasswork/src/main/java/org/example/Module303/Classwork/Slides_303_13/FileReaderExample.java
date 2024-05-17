package org.example.Module303.Classwork.Slides_303_13;

import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) throws IOException {

        File input = new File("output.txt");

        FileReader reader = new FileReader(input);
        BufferedReader br = new BufferedReader(reader);

        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
    }
}
