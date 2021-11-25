package com.jwd.A_SimpleIoStream;

import java.io.*;
import java.util.Arrays;

public class Main_ {
    public static void main(String[] args) {
        InputStream input = null;
        try {
            input = new BufferedInputStream(new FileInputStream("data/info.txt"));
            byte[] arr = new byte[16];
            int numberBytes = input.read(arr);

            System.out.println("as string=" + new String(arr));
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
