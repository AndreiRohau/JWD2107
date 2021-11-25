package com.jwd.G_archive;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class UnPackJar {

    private static final int BUFFER = 2_048;

    public void unpack(final String destinationDirectory, final String nameJar, final boolean isDeleteJar) {
        try (final JarFile jarFile = new JarFile(nameJar)) {
            jarFile.stream().forEach(element -> {
                Path destinationPath = Paths.get(destinationDirectory, element.getName());
                // create dir structure
                destinationPath.getParent().toFile().mkdirs();
                // unpack element
                if (!element.isDirectory()) {
                    writeFile(jarFile, element, destinationPath);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        deleteJar(nameJar, isDeleteJar);
    }

    private void writeFile(final JarFile jarFile, final JarEntry element, final Path destinationPath) {
        int currentByte;
        byte[] data = new byte[BUFFER];
        try (InputStream is = new BufferedInputStream(jarFile.getInputStream(element));
             OutputStream fos = new FileOutputStream(destinationPath.toString());
             OutputStream bos = new BufferedOutputStream(fos, BUFFER)) {
            // write file to disk
            while ((currentByte = is.read(data, 0, BUFFER)) > 0) {
                bos.write(data, 0, currentByte);
            }
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteJar(String nameJar, boolean isDeleteJar) {
        if (isDeleteJar) {
            File jar = Paths.get(nameJar).toFile();
            File dir = jar.getParentFile();
            jar.delete();
            dir.delete();
        }
    }
}
