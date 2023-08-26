package com.example.demo;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createQueryAndPrintStudent(studentDAO);

//            printAllStudents(studentDAO);

//            printAllStudentsOrderByLastName(studentDAO);

//            printStudentsByLastName(studentDAO);

//            updateStudentAndPrint(studentDAO);

//            updateStudentsEmailByMatchingGivenLastNameAndPrint(studentDAO);

//            createAndDeleteStudent(studentDAO);

//            deleteStudentsBasedOnLastNameAndSome(studentDAO);
        };
    }

    private void deleteStudentsBasedOnLastNameAndSome(StudentDAO studentDAO) {
        int num = studentDAO.deleteStudentsBasedOnLastName("thisStudent");
        System.out.println("Number of Rows delete - " + num);
    }

    private void createAndDeleteStudent(StudentDAO studentDAO) {
        Student oneStudent = new Student("delete", "thisStudent", "delete.thisstudent@asdf.asdf.invalid");
        studentDAO.save(oneStudent);

        int id = oneStudent.getId();
        System.out.println("New Student id: " + id);

//        Student tempStudent = studentDAO.findById(id);

        studentDAO.deleteStudent(id);

        Student tempStudent2 = studentDAO.findById(id);
        System.out.println(tempStudent2);
    }

    private void updateStudentsEmailByMatchingGivenLastNameAndPrint(StudentDAO studentDAO) {
        studentDAO.updateStudentsEmailByMatchingGivenLastName("Anney");
    }

    private void updateStudentAndPrint(StudentDAO studentDAO) {
        Student myStudent = studentDAO.findById(4);
        myStudent.setEmail("updatedEmail@some.com.invalid");
        studentDAO.updateStudent(myStudent);
    }

    private void printStudentsByLastName(StudentDAO studentDAO) {
        System.out.println(studentDAO.findByLastName("Anney"));
    }

    private void printAllStudentsOrderByLastName(StudentDAO studentDAO) {
        System.out.println(studentDAO.findAllSortByLastName());
    }

    private void printAllStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        System.out.println(students);
    }

    private void createQueryAndPrintStudent(StudentDAO studentDAO) {

        System.out.println("Creating new Student");
        Student tempStudent = new Student("Rama", "Bandlapally", "something2@fake.com.invalid");

        System.out.println("Saving Student");
        studentDAO.save(tempStudent);

        int newId = tempStudent.getId();
        System.out.println("Saved student. Id: " + newId);

        Student newlyCreatedStudent = studentDAO.findById(newId);
        System.out.println("newlyCreatedStudent: " + newlyCreatedStudent);

    }

}
