package com.jwd.a_domain;

import java.io.Serializable;

public class Student implements Serializable {
    private String login;
    private String faculty;
    private String name;
    private int telephone;
    private Address address;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "login='" + login + '\'' +
                ", faculty='" + faculty + '\'' +
                ", name='" + name + '\'' +
                ", telephone=" + telephone +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (telephone != student.telephone) return false;
        if (login != null ? !login.equals(student.login) : student.login != null) return false;
        if (faculty != null ? !faculty.equals(student.faculty) : student.faculty != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return address != null ? address.equals(student.address) : student.address == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + telephone;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
