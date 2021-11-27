package com.jwd.b_sax;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

import static com.jwd.a_domain.Constant.STUDENTS_XML_FILE_PATH;

public class MainA {
    public static void main(String[] args) {
        final File xmlFile = new File(STUDENTS_XML_FILE_PATH);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = null;
        try {
            saxParser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        XMLReader xmlReader = null;
        try {
            xmlReader = saxParser.getXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        xmlReader.setContentHandler(new ConsoleStudentHandler());
        try {
            xmlReader.parse(xmlFile.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
