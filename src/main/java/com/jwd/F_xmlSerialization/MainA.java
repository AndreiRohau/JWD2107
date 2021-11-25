package com.jwd.F_xmlSerialization;

import org.junit.Test;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

import static org.junit.Assert.assertEquals;

public class MainA {

    private static final String XML_DATA_OUT = "data\\person1.xml";
    private static final String XML_DATA_IN = "data\\person1.xml";

    /*
    NB! in xml transient is serialized!!!!!
     */
    @Test
    public void test_serialize() {
        Person person = new Person();
        person.setComprehensive_string("abra");
        serializePerson(XML_DATA_OUT, person);
    }
    @Test
    public void test_deserialize() {
        Person person = deserialize(XML_DATA_IN);

        System.out.println(person);
        System.out.println("Comprehensive_string=" + person.getComprehensive_string());
        Person expected = new Person();
        expected.setComprehensive_string("abra");
        assertEquals(person, expected);
    }

    private static <T> void serializePerson(String path, T t) {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)))) {
            xmlEncoder.writeObject(t);
            xmlEncoder.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static <T> T deserialize(String path) {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)))) {
            return (T) xmlDecoder.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
