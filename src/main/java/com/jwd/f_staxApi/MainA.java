package com.jwd.f_staxApi;

import static com.jwd.a_domain.Constant.STUDENTS_XML_FILE_PATH;

public class MainA {
    public static void main(String[] args) {
        StudentStaxApiBuilder studentStaxApiBuilder = new StudentStaxApiBuilder();
        studentStaxApiBuilder.parseStudents(STUDENTS_XML_FILE_PATH);
        studentStaxApiBuilder.getStudents().forEach(System.out::println);
    }
}
