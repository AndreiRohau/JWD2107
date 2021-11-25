package com.jwd.D_serialization;

import java.io.*;
import java.util.Base64;

public class MainB {
    public static void main(String[] args) throws InterruptedException {
        Person person = new Person();
        String objectAsString = serializePerson(person);
        Person.setYo_static(20);
        System.out.println("objectAsString=" + objectAsString);

        Person unfrozen = deserialize(objectAsString);

        System.out.println(unfrozen);
    }

    private static String serializePerson(Person person) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            System.out.println(person);
            oos.writeObject(person);
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static Person deserialize(String objectAsString) {
        byte[] data = Base64.getDecoder().decode(objectAsString);
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bais)) {
            return (Person) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
