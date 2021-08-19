package com.jwd.error;

public class User {
    private String name;
    private String name1;
    private int age;
    private int age1;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (age1 != user.age1) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return name1 != null ? name1.equals(user.name1) : user.name1 == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (name1 != null ? name1.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + age1;
        return result;
    }
}
