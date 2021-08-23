package com.jwd.immutable;

public class User implements Cloneable {
    private final Address address;

    public User(Address address) {
        this.address = address; // deep clone
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        User clone = new User(null);
        return clone; // deep clone
    }

    public Address getAddress() {
        return address;
    }
}
