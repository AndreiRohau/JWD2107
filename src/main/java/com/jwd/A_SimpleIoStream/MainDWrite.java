package com.jwd.A_SimpleIoStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainDWrite {
    public static void main(String[] args) {
        try (OutputStream os = new FileOutputStream("data/outfo.txt", true)) {
            os.write('a');
            os.write('b');
            os.write('c');
            os.write('-');
            byte[] value = {65, 67, 100};
            os.write(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
