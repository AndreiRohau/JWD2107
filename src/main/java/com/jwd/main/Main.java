package com.jwd.main;

import com.jwd.util.UtilParent;

public class Main {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
        System.out.println("Hello JWD");

        User u1 = new User();
        u1.name = "Andrei";
        u1.surname = "Rohau";
        u1.showMeYourName();

        User u2 = new User();
        u2.name = "Vasia";
        u2.surname = "Petrov";
        u2.showMeYourName();

        u2 = null;

        //...

        com.jwd.main.Util u = new com.jwd.main.Util();

        Util u_2 = new Util();

        UtilParent utilParent = new UtilParent();
        utilParent.publicMethod();

        UtilChild utilChild = new UtilChild();
        utilChild.publicMethod();
        System.out.println(com.jwd.dataType.Main.mainStaticInt);
    }
}
