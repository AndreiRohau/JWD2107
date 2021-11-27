package com.jwd.a_testScheme;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.logging.Logger;

public class StudentErrorHandler implements ErrorHandler {
    private static final Logger LOGGER = Logger.getLogger(StudentErrorHandler.class.getName());

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        LOGGER.warning(getLineColumnNumber(exception) + "-" + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        LOGGER.warning(getLineColumnNumber(exception) + "-" + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        LOGGER.warning(getLineColumnNumber(exception) + "-" + exception.getMessage());
    }

    private String getLineColumnNumber(SAXParseException exception) {
        return "LINE=" + exception.getLineNumber() + "::COLUMN=" + exception.getColumnNumber()
                + " SHORTENED=" + exception.getLineNumber() + ":" + exception.getColumnNumber();
    }
}
