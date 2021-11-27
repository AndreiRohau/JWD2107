package com.jwd.b_sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ConsoleStudentHandler extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("-----> Document parsing started...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.println("-----> Element parsing started...");
        StringBuffer tagData = new StringBuffer("<" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            tagData.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
        }
        System.out.print(tagData + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
//        System.out.println("-----> Parsing characters...");
        final String string = new String(ch, start, length);
        System.out.print(string);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.println("-----> Element parsing ended...");
        System.out.print("</" + qName + ">");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("-----> Document parsing ended...");
    }
}
