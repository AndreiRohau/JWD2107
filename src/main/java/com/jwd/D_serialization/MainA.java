package com.jwd.D_serialization;

import java.io.*;

public class MainA {
    /*
    serialization
    deserialization
    2 ways to make object serializable:
    1) impl Serializable
    2) all fields includes except static & transient
    3) final beats transient
    4) field order, name, type, new fields - can break de/serialization process
    5) to fulfil 4th point use: private static final long serialVersionUID
    6) serialVersionUID - is serializable!!!
    7) before deserialization process serialVersionUID is checked
     */
    public static void main(String[] args) throws InterruptedException {
        String objectName = "data\\Person1.dat";

//        Person person = new Person();
//        person.setAddress(new Address());
//        person.setComprehensive_string("any str");
//        serializePerson(objectName, person);
//        Person.setYo_static(20);

        Person unfrozen = deserialize(objectName);
        System.out.println(unfrozen);
    }

    private static void serializePerson(String objectName, Person person) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectName))) {
            System.out.println(person);
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person deserialize(String objectName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectName))) {
            return (Person) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
