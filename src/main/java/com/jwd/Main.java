package com.jwd;

import com.jwd.test.Address;
import com.jwd.test.User;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Address address0 = new Address();
        System.out.println(address0);
        Address address1 = new Address();
        Address address2 = new Address();
//        int i[] = { 1, 2 };
//        int j[] = (int[]) i.clone();
//
//        System.out.println(Arrays.toString(i));
//        System.out.println(Arrays.toString(j));
//
//        i[0] = 13;
//
//        System.out.println(Arrays.toString(i));
//        System.out.println(Arrays.toString(j));

        User u1 = new User(1, "qwe", new Address("wow", 1234));
        User u2 = (User) u1.clone();

        User[] users = {u1, u2};
        User[] us = users.clone();


//        User u1 = new User(1, "qwe", new Address("wow", 1234));
//        User u2 = u1;
//
//        System.out.println("u1.getName=" + u1.getName());
//        System.out.println("u2.getName=" + u2.getName());
//
//        u1.setName("012123");
//
//        System.out.println("u1.getName=" + u1.getName());
//        System.out.println("u2.getName=" + u2.getName());



    }
}
