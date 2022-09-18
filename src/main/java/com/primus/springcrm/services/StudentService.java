package com.primus.springcrm.services;

import com.primus.springcrm.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudent(Long id);

    void saveStudent(Student student);

    void deleteStudent(Long id);

}
