package com.jwd;

import java.util.logging.Logger;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        log.info("asdasda");
        int iiii = m1() + m2();
        System.out.println(1 + 2 + "abc" + 1 + 3 + " sdf");

        int[] ints = {1, 2};
        System.out.println(ints.length);
        ints[1] = 1;

    }

    public static int m1(){
        log.info("1");
        return 1;
    }

    public static int m2(){
        log.info("2");
        return 2;
    }

}
