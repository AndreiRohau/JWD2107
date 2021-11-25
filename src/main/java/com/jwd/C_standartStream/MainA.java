package com.jwd.C_standartStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainA {
    public static void main(String[] args) {
        double[] values = {1.20, 3.14};
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("data\\sout.txt")))) {
            for (double value : values) {
                System.out.println(value);
                writer.printf("Java %.2g%n", value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
