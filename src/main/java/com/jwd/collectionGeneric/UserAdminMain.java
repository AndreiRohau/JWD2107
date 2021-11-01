package com.jwd.collectionGeneric;

public class UserAdminMain {
    public static void main(String[] args) {
        User user = new User("John");
        Admin admin = new Admin("Edvard", 123);
        ComparatorUserAdmin<User> comparator = new ComparatorUserAdmin<>();
        System.out.println(comparator.compare(admin, user));
    }
}
