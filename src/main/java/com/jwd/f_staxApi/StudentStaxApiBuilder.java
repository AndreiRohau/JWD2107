package com.jwd.f_staxApi;

import com.jwd.StudentParser;
import com.jwd.a_domain.Address;
import com.jwd.a_domain.Student;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.jwd.a_domain.Constant.*;
import static java.util.Objects.nonNull;

public class StudentStaxApiBuilder implements StudentParser {
    private final List<Student> students;
    private Student student;

    public StudentStaxApiBuilder() {
        students = new ArrayList<>();
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void parseStudents(String fileName) {
        try (final FileInputStream fis = new FileInputStream(fileName)) {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLEventReader reader = inputFactory.createXMLEventReader(fis);
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    processStartElement(reader, event);
                } else if (event.isEndElement()) {
                    processEndElement(event);
                }
            }
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private void processStartElement(XMLEventReader reader, XMLEvent event) throws XMLStreamException {
        final StartElement startElement = event.asStartElement();
        if (isTheSameAs(ELEMENT_STUDENT, startElement)) {
            student = new Student();
            student.setLogin(getAttribute(startElement, ATTRIBUTE_LOGIN));
            student.setFaculty(getAttribute(startElement, ATTRIBUTE_FACULTY));
        } else if (isTheSameAs(ELEMENT_NAME, startElement)) {
            event = reader.nextEvent();
            student.setName(getContent(event));
        } else if (isTheSameAs(ELEMENT_TELEPHONE, startElement)) {
            event = reader.nextEvent();
            student.setTelephone(Integer.parseInt(getContent(event)));
        } else if (isTheSameAs(ELEMENT_ADDRESS, startElement)) {
            student.setAddress(new Address());
        } else if (isTheSameAs(ELEMENT_COUNTRY, startElement)) {
            event = reader.nextEvent();
            student.getAddress().setCountry(getContent(event));
        } else if (isTheSameAs(ELEMENT_CITY, startElement)) {
            event = reader.nextEvent();
            student.getAddress().setCity(getContent(event));
        } else if (isTheSameAs(ELEMENT_STREET, startElement)) {
            event = reader.nextEvent();
            student.getAddress().setStreet(getContent(event));
        }
    }

    private String getContent(XMLEvent event) {
        return event.asCharacters().getData();
    }

    private void processEndElement(XMLEvent event) {
        EndElement endElement = event.asEndElement();
        if (isTheSameAs(ELEMENT_STUDENT, endElement)) {
            students.add(student);
            student = null;
        }
    }

    private boolean isTheSameAs(String elementName, StartElement startElement) {
        return elementName.equals(startElement.getName().getLocalPart());
    }

    private boolean isTheSameAs(String elementName, EndElement endElement) {
        return elementName.equals(endElement.getName().getLocalPart());
    }

    private String getAttribute(final StartElement startElement, final String attributeName) {
        String value = null;
        final Attribute attribute = startElement.getAttributeByName(new QName(attributeName));
        if (nonNull(attribute)) {
            value = attribute.getValue();
        }
        return value;
    }
}
