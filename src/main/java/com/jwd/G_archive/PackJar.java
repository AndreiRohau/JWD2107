package com.jwd.G_archive;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.stream.Collectors;
import java.util.zip.Deflater;

public class PackJar {

    private static final int BUFFER = 2_048;

    public void pack(final String inputDirName, final int depth, final String jarName, final boolean isDeleteArchived) {
        Path inputDirPath = Paths.get(inputDirName);
        if (Files.notExists(inputDirPath) || !Files.isDirectory(inputDirPath)) {
            throw new RuntimeException(inputDirName + " not found.");
        }
        // getting files to be archived
        List<Path> listFilesToJar = findFileList(depth, inputDirPath);
        // archiving process
        archiveToJar(jarName, listFilesToJar.toArray(new Path[]{}));
        // delete processed files
        deleteArchived(isDeleteArchived, inputDirPath);
    }

    private List<Path> findFileList(int depth, Path dirPath) {
        try {
            return Files.walk(dirPath, depth)
                    .filter(element -> !Files.isDirectory(element))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void archiveToJar(final String jarName, final Path[] filesToJar) {
        // creates dir if not exists
        File jar = new File(jarName);
        jar.getParentFile().mkdirs();
        try (JarOutputStream jos = new JarOutputStream(new FileOutputStream(jar));) {
            jos.setLevel(Deflater.DEFAULT_COMPRESSION);
            byte[] buffer = new byte[BUFFER];

            for (Path path : filesToJar) {
                String file = path.toString();
                jos.putNextEntry(new JarEntry(file));
                try (InputStream is = new FileInputStream(file)) {
                    int len;
                    while ((len = is.read(buffer)) > 0) {
                        jos.write(buffer, 0, len);
                    }
                    jos.closeEntry();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteArchived(final boolean isDeleteArchived, final Path dirPath) {
        if (isDeleteArchived) {
            try {
                Files.walk(dirPath)
                        .filter(Files::isRegularFile)
                        .map(Path::toFile)
                        .forEach(File::delete);
                dirPath.toFile().delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
