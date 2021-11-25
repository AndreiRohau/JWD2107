package com.jwd.B_CharStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MainB {
    public static void main(String[] args) {
        String dir = "data";
        String file = "ipsum.txt";
        Path path = FileSystems.getDefault().getPath(dir, file);

        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            lines.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
