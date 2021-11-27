package com.jwd.c_dom;

import com.jwd.StudentParser;
import com.jwd.a_domain.Address;
import com.jwd.a_domain.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.jwd.a_domain.Constant.*;
import static java.util.Objects.nonNull;

public class StudentsDomBuilder implements StudentParser {
    private final DocumentBuilder documentBuilder;
    private final List<Student> students;
    private Document document;

    public StudentsDomBuilder() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            documentBuilder = factory.newDocumentBuilder();
            students = new ArrayList<>();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void parseStudents(final String fileName) {
        try {
            document = documentBuilder.parse(fileName);
            final Element root = document.getDocumentElement();
            final NodeList elements = root.getElementsByTagName(ELEMENT_STUDENT);
            convertToStudents(elements);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private void convertToStudents(final NodeList elements) {
        for (int i = 0; i < elements.getLength(); i++) {
            Element element = (Element) elements.item(i);
            Student student = convertToStudent(element);
            students.add(student);
        }
    }

    private Student convertToStudent(final Element element) {
        final Student student = new Student();
        student.setLogin(element.getAttribute(ATTRIBUTE_LOGIN));
        student.setFaculty(element.getAttribute(ATTRIBUTE_FACULTY));
        student.setName(getElementContent(element, ELEMENT_NAME));
        final String elementContent = getElementContent(element, ELEMENT_TELEPHONE);
        student.setTelephone(nonNull(elementContent) ? Integer.parseInt(elementContent) : 0);
        final Element addressElement = (Element) element.getElementsByTagName(ELEMENT_ADDRESS).item(0);
        student.setAddress(convertToAddress(addressElement));
        return student;
    }

    private Address convertToAddress(final Element element) {
        final Address address = new Address();
        address.setCountry(getElementContent(element, ELEMENT_COUNTRY));
        address.setCity(getElementContent(element, ELEMENT_CITY));
        address.setStreet(getElementContent(element, ELEMENT_STREET));
        return address;
    }

    private String getElementContent(Element element, String elementName) {
        NodeList childNodes = element.getChildNodes();
        Node childNode = null;
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (elementName.equals(node.getNodeName())) {
                childNode = node;
                break;
            }
        }
        return nonNull(childNode) ? childNode.getTextContent() : null;
    }
}
