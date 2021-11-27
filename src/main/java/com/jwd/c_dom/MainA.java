package com.jwd.c_dom;

import static com.jwd.a_domain.Constant.STUDENTS_XML_FILE_PATH;

public class MainA {
    public static void main(String[] args) {
        StudentsDomBuilder domBuilder = new StudentsDomBuilder();
        domBuilder.parseStudents(STUDENTS_XML_FILE_PATH);
        domBuilder.getStudents().forEach(System.out::println);
    }
}
