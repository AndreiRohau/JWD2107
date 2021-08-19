package com.jwd.closeable;

import com.jwd.Main;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.util.Objects.nonNull;

public class MainClosable {

    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
//        extracted();
//        extracted();

        final String file = "filename.txt";
        final String data = "5432";

        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(file);

            myWriter.write(data);
            myWriter.write(data);
            // ...
            myWriter.flush();

            myWriter.write(data);

        } catch (IOException e) {
            LOGGER.warning("An exception occurred.");
            e.printStackTrace();
        } finally {
            close(myWriter);
        }
        System.out.println("END");
    }

    private static void close(Closeable closeable) {
        if (nonNull(closeable)) {
            try {
                closeable.close();
            } catch (IOException e) {
                LOGGER.warning("An exception occurred during flushing or closing myWriter.");
                e.printStackTrace();
            }
        }
    }

    private static void extracted() {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println("next=" + next);
        // ...
        close(scanner);
    }
}
