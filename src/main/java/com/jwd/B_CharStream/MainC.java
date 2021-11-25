package com.jwd.B_CharStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MainC {
    public static void main(String[] args) {
        Path path = Paths.get("data\\ipsum.txt");
        try (Stream<String> stream = Files.newBufferedReader(path).lines()) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
