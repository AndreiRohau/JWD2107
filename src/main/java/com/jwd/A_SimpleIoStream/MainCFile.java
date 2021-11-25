package com.jwd.A_SimpleIoStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class MainCFile {
    public static void main(String[] args) throws IOException {
        File info_txt = new File("data/info.txt");

//        File dataFolder = info_txt.getParentFile();
//        if (!dataFolder.exists()) {
//            dataFolder.mkdirs();
//        }
//        if (!info_txt.exists()) {
//            info_txt.createNewFile();
//        }
//        System.out.println(dataFolder.isDirectory());
//        System.out.println(info_txt.isFile());
        try (FileInputStream input = new FileInputStream(info_txt)) {
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
