package com.jwd.test;

import java.util.Objects;

public class Address extends BaseAddress implements Cloneable {
    static {
        System.out.println("1 static Address");
    }
    private String city;
    private int postCode;
    {
        postCode = 0;
        System.out.println("1 Address");

    }

    static {
        System.out.println(" 2 static Address");
    }
    public Address() {
        this("No");
    }

    static {
        System.out.println("3 static Address");
    }

    {
        postCode = 0;
        System.out.println("2 Address");

    }
    private Address(String city) {
        this(city, 999999);
    }

    public Address(String city, int postCode) {
        super("Earth");
        this.city = city;
        this.postCode = postCode;
    }

    {
        postCode = 0;
        System.out.println("3 Address");

    }
    public Address(Address address) {
        super("");
        this.city = address.city;
        this.postCode = address.postCode;
    }

    static {
        System.out.println("4 static Address");
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        final Address address = new Address();
        address.setCity(city);
        address.setPostCode(postCode);
        return address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return postCode == address.postCode && Objects.equals(city, address.city);
    }

    {
        postCode = 0;
        System.out.println("4 Address");

    }
    static {
        System.out.println("5 static Address");
    }
    @Override
    public int hashCode() {
        return Objects.hash(city, postCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", postCode=" + postCode +
                '}';
    }
}
