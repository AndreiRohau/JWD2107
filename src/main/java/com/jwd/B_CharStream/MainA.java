package com.jwd.B_CharStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainA {
    public static void main(String[] args) {
        File file = new File("data/ipsum.txt");
        StringBuilder lines = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String tmp;
            while ((tmp = reader.readLine()) != null) {
                lines.append(tmp);
                lines.append("\n");
            }
            System.out.println(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
