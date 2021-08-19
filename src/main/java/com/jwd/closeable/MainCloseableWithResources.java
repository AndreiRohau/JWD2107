package com.jwd.closeable;

import com.jwd.Main;

import java.io.*;
import java.util.logging.Logger;

public class MainCloseableWithResources {

    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        final String file = "filename.txt";
        final String data = "any text to be out";

//        writeWithBufferedOutputStream(file, data);
        try (FileWriter myWriter = new FileWriter(file)) {

            write(myWriter, data);

        } catch (IOException e) {
            LOGGER.warning("Exception occupied.");
            e.printStackTrace();
        }
    }

    private static void write(Writer myWriter, String data) throws IOException {
        myWriter.write(data);
        myWriter.flush();
    }

    private static void writeWithBufferedOutputStream(String file, String data) {
        byte[] bytes = data.getBytes();
        byte[] newBytes = "totally new data".getBytes();
        try (OutputStream fos1 = new FileOutputStream(file);
             OutputStream out1 = new BufferedOutputStream(fos1);
             OutputStream fos2 = new FileOutputStream(file);
             OutputStream out2 = new BufferedOutputStream(fos2)) {

            out1.write(bytes);
            out1.flush();

            out2.write(newBytes);
            out2.flush();
        } catch (IOException e) {
            LOGGER.warning("An exception occurred.");
            e.printStackTrace();
        }
    }
}
