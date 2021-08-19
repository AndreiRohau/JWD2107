package com.jwd.error;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainSuppressedException {
    public static void main(String[] args) {
        try {
            demoSuppressedException("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void demoSuppressedException(String filePath) throws IOException {
        IOException firstException = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            firstException = new IOException(e);
            throw firstException;
        } finally {
            processWithoutSuppressed(fis);
//            processWithSuppressed(fis, firstException);
        }
    }

    private static void processWithoutSuppressed(FileInputStream fis) throws IOException {
        fis.close();
    }

    private static void processWithSuppressed(FileInputStream fis, IOException firstException) throws IOException {
        try {
            fis.close();
        } catch (NullPointerException npe) {
            if (firstException != null) {
                npe.addSuppressed(firstException);
            }
            throw npe;
        }
    }

}
