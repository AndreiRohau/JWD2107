package com.jwd.G_archive;

import org.junit.Test;

public class MainA {
    public void main(String[] args) {
//        java.util.zip
//        java.util.jar
    }

    @Test
    public void test_packJar() {
        final String inputDirName = "data";
        final int depth = 10;
        final String jarName = "jars/packed.jar";

        PackJar packJar = new PackJar();
        packJar.pack(inputDirName, depth, jarName, true);
    }

    @Test
    public void test_unpackJar() {
//        final String dirName = "../JWD2107"; // result is same as below
        final String dirName = "./";
        final String jarName = "jars/packed.jar";

        UnPackJar unPackJar = new UnPackJar();
        unPackJar.unpack(dirName, jarName, true);
    }
}
