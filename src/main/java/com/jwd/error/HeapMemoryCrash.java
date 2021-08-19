package com.jwd.error;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

public class HeapMemoryCrash {
    // todo VM options -Xms20m -Xmx50m
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] a) {
        int max = 1000;
        Object[] arr = new Object[max];
        heapCheck();
        for (int n = 0; n < max; n++) {
            arr[n] = new long[10 * 1024 * 128];
            System.out.println((n + 1) + ": "
                    + ((n + 1) * 10) + " MB of objects created.");
            heapCheck();
        }
    }

    public static void heapCheck() {
        Runtime rt = Runtime.getRuntime();
        rt.gc();
        long total = rt.totalMemory();
        long free = rt.freeMemory();
        long used = total - free;
        System.out.printf("Total memory: %s%n", toMegabytes(total));
        System.out.printf(" Free memory: %s%n", toMegabytes(free));
        System.out.printf(" Used memory: %s%n", toMegabytes(used));
        System.out.println("Press ENTER key to continue: ");
        SCANNER.nextLine();
    }

    public static String toMegabytes(long bytes) {
        if (-1000 < bytes && bytes < 1000) {
            return bytes + " B";
        }
        CharacterIterator ci = new StringCharacterIterator("kMGTPE");
        while (bytes <= -999_950 || bytes >= 999_950) {
            bytes /= 1000;
            ci.next();
        }
        return String.format("%.1f %cB", bytes / 1000.0, ci.current());
    }
}
