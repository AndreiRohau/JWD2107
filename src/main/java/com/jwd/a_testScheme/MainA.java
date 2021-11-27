package com.jwd.a_testScheme;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

import static com.jwd.a_domain.Constant.STUDENTS_XML_FILE_PATH;
import static com.jwd.a_domain.Constant.STUDENTS_XSD_FILE_PATH;

public class MainA {
    public static void main(String[] args) {
        final String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        final SchemaFactory factory = SchemaFactory.newInstance(language);
        final File schemaLocation = new File(STUDENTS_XSD_FILE_PATH);
        try {
            // schema creation
            Schema schema = factory.newSchema(schemaLocation);
            // creating a schema-based validator
            Validator validator = schema.newValidator();
            Source source = new StreamSource(STUDENTS_XML_FILE_PATH);
            // document check
            validator.setErrorHandler(new StudentErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            System.err.println(STUDENTS_XML_FILE_PATH + " is not valid");
            e.printStackTrace();
        }
    }
}
