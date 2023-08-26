package com.example.demo.dao;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findAllSortByLastName();

    List<Student> findByLastName(String lastName);

    void updateStudent(Student student);

    void updateStudentsEmailByMatchingGivenLastName(String theLastName);

    void deleteStudent(Integer id);
    int deleteStudentsBasedOnLastName(String theLastName);
}
