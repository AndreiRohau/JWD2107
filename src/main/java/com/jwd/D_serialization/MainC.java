package com.jwd.D_serialization;

import java.io.*;

public class MainC {

    public static void main(String[] args) throws InterruptedException {
        String objectName = "data\\PersonImpl_1.dat";

        PersonImpl personImpl = new PersonImpl(33, 88, "99", "__", new Address(), "implName", 1234);
        serializePerson(objectName, personImpl);
        Person.setYo_static(20);

        PersonImpl unfrozen = deserialize(objectName);

        System.out.println(unfrozen);
    }

    private static <T> T deserialize(String objectName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectName))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> void serializePerson(String objectName, T t) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectName))) {
            System.out.println(t);
            oos.writeObject(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
