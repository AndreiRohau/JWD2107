package com.jwd.A_SimpleIoStream;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class MainEPaths {
    public static void main(String[] args) throws IOException {
        String s = "data/info.txt";
        File file = new File(s);
        Path path1 = file.toPath();
        Path path2 = Paths.get(s);

        Path path3 = FileSystems.getDefault().getPath(s);
        System.out.println();
        System.out.println("Let's find all files of .java");
        Path path4 = FileSystems.getDefault().getPath("src");

        if (Files.exists(path4) && Files.isDirectory(path4)) {
            int maxDepth = 6; // 7
            try (Stream<Path> streamDir = Files.find(path4, maxDepth, (p, a) -> String.valueOf(p).endsWith(".java"))) {
                long counter = streamDir
                        .map(element -> {
                            return String.valueOf(element);
                        })
                        .peek(element -> System.out.println(element))
                        .count();
                System.out.println("found: " + counter);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("NICE");

        System.out.println("A few file examples:\n");
        File file_ = new File(File.separator + "com" + File.separator + "file.txt");
        File dir = new File("C:\\Program Files\\Java\\jdk1.8.0_301");
        File file1 = new File(dir, "THIRDPARTYLICENSEREADME.txt");
        File file2 = new File("C:\\Program Files\\Java\\jdk1.8.0_301", "THIRDPARTYLICENSEREADME.txt");
        System.out.println(dir.isDirectory());
        System.out.println(dir.isFile());
        System.out.println(dir.canExecute());
        System.out.println(dir.exists());
        System.out.println(dir.getPath());
        System.out.println(dir.canRead());
        System.out.println(dir.getCanonicalFile());
        System.out.println(dir.getAbsoluteFile());
        System.out.println(dir.getPath());
        System.out.println(dir.getParent());
        System.out.println(dir.getFreeSpace());
        System.out.println(dir.createNewFile());
        System.out.println("---> more ???");
        System.out.println(Arrays.toString(dir.list()));
        System.out.println(Arrays.toString(dir.listFiles()));
        System.out.println("---");
        for (int i = 0; i < dir.list().length; i++) {
            System.out.print(dir.list()[i] + " <---------> ");
            System.out.println(dir.listFiles()[i]);
        }
    }
}
