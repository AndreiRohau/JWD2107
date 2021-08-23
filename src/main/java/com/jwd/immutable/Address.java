package com.jwd.immutable;

public class Address implements Cloneable {
    private String city;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // deep clone
    }
}
