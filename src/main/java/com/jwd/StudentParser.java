package com.jwd;

import com.jwd.a_domain.Student;

import java.util.List;

public interface StudentParser {
    List<Student> getStudents();
    void parseStudents(final String fileName);
}
