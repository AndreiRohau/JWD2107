package com.jwd.C_standartStream;

import java.io.*;

public class MainB {
    public static void main(String[] args) {
        double[] values = {1.20, 3.14};
        try (PrintStream stream = new PrintStream(new FileOutputStream("data\\sout.txt"))) {
            System.setOut(stream);
            for (double value : values) {
                stream.printf("Oracle %.2g%n", value);
                System.out.printf("sout Oracle %.2g%n", value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
