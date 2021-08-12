package com.jwd;

import com.jwd.bean.ClassicBean;

public class AppMain {
    public static void main(String[] args) {
        int i;

        i = getInt("integer");

        ClassicBean object = new ClassicBean(i);

        System.out.println(object.getNumber());

        System.out.println("End");
    }

    public static int getInt(String text) {
        int num = text.length();
        return num;
    }
}
