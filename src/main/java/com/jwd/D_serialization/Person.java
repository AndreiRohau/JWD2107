package com.jwd.D_serialization;

import java.io.Serializable;

public class Person implements Serializable {
    // NB! will be serialized
    private static final long serialVersionUID = 3; // use generator accepting field names/types/order

    private static final int yo_static_final = 1;
    private static int yo_static = 2;
    private transient int yo_transient = 3;
    // NB! will be serialized
    private final transient int yo_transient_final = 6;

    private final int final_int = 7;
    private int simple_int = 8;
    private String simple_string = "9";
    private String comprehensive_string;
    // serializable
    private Address address;

    public Person() {
    }

    public Person(int yo_transient, int simple_int, String simple_string, String comprehensive_string, Address address) {
        this.yo_transient = yo_transient;
        this.simple_int = simple_int;
        this.simple_string = simple_string;
        this.comprehensive_string = comprehensive_string;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "yo_static_final=" + yo_static_final +
                ", yo_static=" + yo_static +
                ", yo_transient=" + yo_transient +
                ", yo_transient_final=" + yo_transient_final +
                ", final_int=" + final_int +
                ", simple_int=" + simple_int +
                ", simple_string='" + simple_string + '\'' +
                ", comprehensive_string='" + comprehensive_string + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (yo_transient != person.yo_transient) return false;
        if (yo_transient_final != person.yo_transient_final) return false;
        if (final_int != person.final_int) return false;
        if (simple_int != person.simple_int) return false;
        if (simple_string != null ? !simple_string.equals(person.simple_string) : person.simple_string != null)
            return false;
        if (comprehensive_string != null ? !comprehensive_string.equals(person.comprehensive_string) : person.comprehensive_string != null)
            return false;
        return address != null ? address.equals(person.address) : person.address == null;
    }

    @Override
    public int hashCode() {
        int result = yo_transient;
        result = 31 * result + yo_transient_final;
        result = 31 * result + final_int;
        result = 31 * result + simple_int;
        result = 31 * result + (simple_string != null ? simple_string.hashCode() : 0);
        result = 31 * result + (comprehensive_string != null ? comprehensive_string.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static int getYo_static_final() {
        return yo_static_final;
    }

    public static int getYo_static() {
        return yo_static;
    }

    public static void setYo_static(int yo_static) {
        Person.yo_static = yo_static;
    }

    public int getYo_transient() {
        return yo_transient;
    }

    public void setYo_transient(int yo_transient) {
        this.yo_transient = yo_transient;
    }

    public int getYo_transient_final() {
        return yo_transient_final;
    }

    public int getFinal_int() {
        return final_int;
    }

    public int getSimple_int() {
        return simple_int;
    }

    public void setSimple_int(int simple_int) {
        this.simple_int = simple_int;
    }

    public String getSimple_string() {
        return simple_string;
    }

    public void setSimple_string(String simple_string) {
        this.simple_string = simple_string;
    }

    public String getComprehensive_string() {
        return comprehensive_string;
    }

    public void setComprehensive_string(String comprehensive_string) {
        this.comprehensive_string = comprehensive_string;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
