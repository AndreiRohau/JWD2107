package com.jwd.b_sax;

import com.jwd.StudentParser;
import com.jwd.a_domain.Address;
import com.jwd.a_domain.Student;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.jwd.a_domain.Constant.*;
import static java.util.Objects.nonNull;

public class StudentHandler extends DefaultHandler implements StudentParser {

    private List<Student> students;
    private String currentElement;
    private Student student;
    private Address address;

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void parseStudents(String fileName) {
        try {
            final File xmlFile = new File(STUDENTS_XML_FILE_PATH);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(this);
            xmlReader.parse(xmlFile.getPath());
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case ELEMENT_STUDENTS:
                students = new ArrayList<>();
                break;
            case ELEMENT_STUDENT:
                student = new Student();
                student.setLogin(attributes.getValue(ATTRIBUTE_LOGIN));
                student.setFaculty(attributes.getValue(ATTRIBUTE_FACULTY));
                break;
            case ELEMENT_ADDRESS:
                address = new Address();
                student.setAddress(address);
                break;
            case ELEMENT_NAME:
            case ELEMENT_TELEPHONE:
            case ELEMENT_COUNTRY:
            case ELEMENT_CITY:
            case ELEMENT_STREET:
                currentElement = qName;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        final String string = new String(ch, start, length);
        if (nonNull(currentElement)) {
            switch (currentElement) {
                case ELEMENT_NAME:
                    student.setName(string);
                    break;
                case ELEMENT_TELEPHONE:
                    student.setTelephone(Integer.parseInt(string));
                    break;
                case ELEMENT_COUNTRY:
                    address.setCountry(string);
                    break;
                case ELEMENT_CITY:
                    address.setCity(string);
                    break;
                case ELEMENT_STREET:
                    address.setStreet(string);
                    break;
            }
            currentElement = null;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case ELEMENT_ADDRESS:
                address = null;
                break;
            case ELEMENT_STUDENT:
                students.add(student);
                student = null;
        }
    }
}
