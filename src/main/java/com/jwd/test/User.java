package com.jwd.test;

import java.util.Objects;

public class User implements Cloneable {
    {
        System.out.println("0 ");
    }
    static {
        System.out.println("1 static");
    }
    private int id;
    {
        System.out.println("1 ");
    }

    private String name;
    {
        System.out.println("2 ");
    }

    public static final String FINAL_STRING;
    static {
        FINAL_STRING = "asd";
        System.out.println("1.5 static");
    }

    private Address address;
    {
        System.out.println("3 ");
    }

    static {
        System.out.println("2 static");
    }

    public User() {
    }

    {
        System.out.println("4 ");
    }
    public User(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    {
        System.out.println("5 ");
    }
    static {
        System.out.println("3 static");
    }

    {
        System.out.println("6 ");
    }

    public static String getUserClassName() {
        return User.class.getName();
    }

    public static String getUserClassName(int i) {
        return User.class.getName();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        User user = new User(id, name, (Address) address.clone());
//        user.setId(id);
//        user.setName(name);
//        user.setAddress((Address) address.clone());
        return user;
    }

    public int getId() {
        return id;
    }

    protected int getId(int i) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    {
        System.out.println("7 ");
    }

    static {
        System.out.println("4 static");
    }

    {
        System.out.println("8 ");
    }
}
