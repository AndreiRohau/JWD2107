package com.jwd.inner;

import java.util.Comparator;

public class User {
    private Long userId;
    private String name;
    private Long age;
    private Address address;

    // private protected public abstract final - class
    public class Address {
        private static final String sf = "static final";
//        private static String s = "static final";
        private String country;
        private String city;
        private String code;
        private String street;
        {
            // this.userId; // this belongs to address
            System.out.println(userId);
            System.out.println(User.this);
        }
    }

    public static class UserAddressComparator implements Comparator<User> {
        public static void staticM(){}

        @Override
        public int compare(User o1, User o2) {
            return (o1.name).compareTo(o2.name);
        }
    }

}
