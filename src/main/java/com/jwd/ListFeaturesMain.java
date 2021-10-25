package com.jwd;

import java.util.ArrayList;
import java.util.List;

public class ListFeaturesMain {
    public static void main(String[] args) {
        List<Useless> list = new ArrayList<>();
        User user = new User();
        Product product = new Product();
        list.add(user);
        list.add(product);

        System.out.println(list.indexOf(product));

        showUseless(list);
    }

    private static void showUseless(List<Useless> list) {
        for (Useless useless : list) {
            if (useless.isUseless()) {
                System.out.println(useless + " ");
            }
        }
    }

    interface Useless {
        boolean isUseless();
    }

    static class Product implements Useless {
        String productName;
        @Override
        public boolean isUseless() {
            return false;
        }
    }

    static class User implements Useless {
        String userName;
        @Override
        public boolean isUseless() {
            return true;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    '}';
        }
    }
}
