package com.jwd.immutable;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableObject {
    private final String date;
    private final int i;
    private final String str;
    private final User user;
    private final List<User> users;

    public ImmutableObject(String date, int i, String str, User user, List<User> users) {
        this.date = date; // deep clone
        this.i = i; // deep clone
        this.str = str; // deep clone
        this.user = user; // deep clone
        this.users = users; // deep clone
    }

    public String getDate() {
        return date;
    }

    public int getI() {
        return i; // deep clone
    }

    public String getStr() {
        return str; // deep clone
    }

    public User getUser() {
        return user; // deep clone
    }

    public List<User> getUsers() {
        List<User> clone = new ArrayList<>();
        for (User u : users) {
            try {
                clone.add((User) u.clone());  // deep clone
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return clone;
    }
}
