package com.jwd.A_SimpleIoStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class MainA {
    public static void main(String[] args) {
        FileInputStream input = null;
        try {
            input = new FileInputStream("data/info.txt");
            int code = input.read();
            System.out.println(code + " char=" + (char) code);
            byte[] arr = new byte[16];
            int numberBytes = input.read(arr);
            System.out.println("numberBytes=" + numberBytes);
            System.out.println(Arrays.toString(arr));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
