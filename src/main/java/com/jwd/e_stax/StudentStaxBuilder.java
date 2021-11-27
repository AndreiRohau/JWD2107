package com.jwd.e_stax;

import com.jwd.StudentParser;
import com.jwd.a_domain.Address;
import com.jwd.a_domain.Student;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.jwd.a_domain.Constant.*;
import static java.util.Objects.isNull;

public class StudentStaxBuilder implements StudentParser {
    private List<Student> students;
    private XMLInputFactory inputFactory;

    public StudentStaxBuilder() {
        inputFactory = XMLInputFactory.newFactory();
        students = new ArrayList<>();
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void parseStudents(final String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fis);
            // stax parse
            while (reader.hasNext()) {
                final int elementType = reader.next();
                if (elementType == XMLStreamConstants.START_ELEMENT) {
                    final String elementName = reader.getLocalName();
                    if (elementName.equals(ELEMENT_STUDENT)) {
                        final Student student = parseStudent(reader);
                        students.add(student);
                    }
                }
            }
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private Student parseStudent(XMLStreamReader reader) {
        try {
            Student student = new Student();
            student.setLogin(reader.getAttributeValue(null, ATTRIBUTE_LOGIN));
            student.setFaculty(reader.getAttributeValue(null, ATTRIBUTE_FACULTY));

            while (reader.hasNext()) {
                final int elementType = reader.next();
                if (elementType == XMLStreamConstants.START_ELEMENT) {
                    switch (reader.getLocalName()) {
                        case ELEMENT_NAME:
                            student.setName(getElementContent(reader));
                            break;
                        case ELEMENT_TELEPHONE:
                            String result = getElementContent(reader);
                            student.setTelephone(isNull(result) || result.isEmpty() ? 0 : Integer.parseInt(result));
                            break;
                        case ELEMENT_ADDRESS:
                            final Address address = parseAddress(reader);
                            student.setAddress(address);
                            break;
                    }
                } else if (elementType == XMLStreamConstants.END_ELEMENT
                        && ELEMENT_STUDENT.equalsIgnoreCase(reader.getLocalName())) {
                    break;
                }
            }
            return student;
        } catch (XMLStreamException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private Address parseAddress(XMLStreamReader reader) {
        try {
            Address address = new Address();
            while (reader.hasNext()) {
                final int elementType = reader.next();
                if (elementType == XMLStreamConstants.START_ELEMENT) {
                    switch (reader.getLocalName()) {
                        case ELEMENT_COUNTRY:
                            address.setCountry(getElementContent(reader));
                            break;
                        case ELEMENT_CITY:
                            address.setCity(getElementContent(reader));
                            break;
                        case ELEMENT_STREET:
                            address.setStreet(getElementContent(reader));
                            break;
                    }
                } else if (elementType == XMLStreamConstants.END_ELEMENT
                        && ELEMENT_ADDRESS.equalsIgnoreCase(reader.getLocalName())) {
                    break;
                }
            }
            return address;
        } catch (XMLStreamException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private String getElementContent(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
