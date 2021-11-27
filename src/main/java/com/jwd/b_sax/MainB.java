package com.jwd.b_sax;

import com.jwd.StudentParser;
import com.jwd.a_domain.Student;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.jwd.a_domain.Constant.STUDENTS_XML_FILE_PATH;

public class MainB {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//        runClassic();
        runEnhanced();
    }

    private static void runClassic() throws ParserConfigurationException, SAXException, IOException {
        final File xmlFile = new File(STUDENTS_XML_FILE_PATH);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        StudentHandler studentHandler = new StudentHandler();
        xmlReader.setContentHandler(studentHandler);
        xmlReader.parse(xmlFile.getPath());

        List<Student> students = studentHandler.getStudents();
        students.forEach(System.out::println);
    }

    private static void runEnhanced() {
        StudentParser studentHandler = new StudentHandler();
        studentHandler.parseStudents(STUDENTS_XML_FILE_PATH);
        studentHandler.getStudents().forEach(System.out::println);
    }
}
