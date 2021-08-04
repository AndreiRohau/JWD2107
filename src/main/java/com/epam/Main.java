package com.epam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        ifBlock();
//        whileBlock();
//        doWhileBlock();
//        simpleAlmostEndlessApp();
//        forCycleBlock();
//        forEachBlock();
//        switchBlock();

//        System.out.println(TmpClass.FINAL_STRING);
//        System.out.println(TmpClass.tmpStaticFunction());
//
//        TmpClass c2 = new TmpClass();
//        TmpClass c3 = new TmpClass();
//        TmpClass c4 = new TmpClass();

//        int i = 10;

        TmpClass c1 = new TmpClass("1");

        System.out.println(c1.tmpString);
        m(c1);

        System.out.println(c1.tmpString);
//        assert i == 10;

    }

    private static void m(final TmpClass tmpClass) {
        tmpClass.tmpString = "changed";
    }

    private static void switchBlock() {
//        String s = "b";
        String choice = "c";
        switch (choice) {
            case "a":
                System.out.println("case 1=" + choice);
                break;
            case "b":
                System.out.println("case 2=" + choice);
                break;
            case "c":
                System.out.println("case 3=" + choice);
                break;
            default:
                System.out.println("default" + choice);
        }
    }

    private static void forEachBlock() {
        //                   0     1     2     3     4    5     6     7     8      9
        String[] strings = {"q", "e8", "e7", "e6", "e5", "4e", "e3", "e2", "e1", "sdf"};
        System.out.println("strings.length=" + strings.length);

        for (String str : strings) {
            System.out.println(str);
            if (str.equals("4e")) {
                strings[5] = "1234123412341234";
            }
        }
        System.out.println("_________________");
        for (String str : strings) {
            System.out.println(str);
        }
    }

    private static void doWhileBlock() {
        System.out.println("out");
        int i = -1;
        do {
            System.out.println("in=" + i);
            i--;
        } while (i > 0);
        System.out.println("end");
    }

    private static void ifBlock() {
        int i = 1;
        boolean bool1 = i == 1;
        System.out.println("out");

        if (true) {
            System.out.println("in-1");
        } else if (i == 2) {
            System.out.println("in-2");
        } else {
            System.out.println("in-default");
        }

        System.out.println("end");
    }

    private static void whileBlock() {
        System.out.println("out");
        int i = 10;

        while (i > 0 && i != 5) {
            System.out.println("in=" + i);
            i--;

            //  && i != 5
//            if (i == 5) {
//                break;
//            }
        }

        System.out.println("end");
    }

    private static void simpleAlmostEndlessApp() {
        System.out.println("Enter a number 1 or 2, any other leads to closure of the APP:");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("your choise is " + choice);

            } else if (choice == 2) {
                System.out.println("your choise is " + choice);

            } else {
                System.out.println("App closes");
                break;
            }
        }
    }

    private static void forCycleBlock() {
        //                   0     1     2     3     4    5     6     7     8      9
        String[] strings = {"q", "e8", "e7", "e6", "e5", "4e", "e3", "e2", "e1", "sdf"};
        System.out.println("strings.length=" + strings.length);

        for (int i = 0; i < strings.length; i++) {
            System.out.print("strings[" + i + "]=" + strings[i] + " ==== PROCESS ==== ");
            strings[i] = strings[i] + "-processed";
            System.out.println("strings[" + i + "]=" + strings[i]);
        }
        System.out.println("end");
    }
}
