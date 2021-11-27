package com.jwd.e_stax;

import static com.jwd.a_domain.Constant.STUDENTS_XML_FILE_PATH;

public class MainA {
    public static void main(String[] args) {
        StudentStaxBuilder staxBuilder = new StudentStaxBuilder();
        staxBuilder.parseStudents(STUDENTS_XML_FILE_PATH);
        staxBuilder.getStudents().forEach(System.out::println);
    }
}
