package com.jwd.d_creationXml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;

import static com.jwd.a_domain.Constant.BOOKS_XML_FILE_PATH;

public class MainA {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("book");
            document.appendChild(rootElement);

            Element childElement;
            childElement = document.createElement("name");
            childElement.appendChild(document.createTextNode("Java for you"));
            rootElement.appendChild(childElement);

            childElement = document.createElement("author");
            childElement.appendChild(document.createTextNode("Nick"));
            childElement.setAttribute("id", "14");
            rootElement.appendChild(childElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileWriter(BOOKS_XML_FILE_PATH));
            transformer.transform(source, result);

        } catch (ParserConfigurationException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
