package com.jwd.A_SimpleIoStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class MainB {

    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("data/info.txt")) {
            byte[] arr = new byte[input.available()];
            input.read(arr);

            System.out.println("actual=" + Arrays.toString(arr));
            System.out.println("as string=" + new String(arr));

            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : arr) {
                stringBuffer.append((char) b);
            }
            System.out.println(stringBuffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
