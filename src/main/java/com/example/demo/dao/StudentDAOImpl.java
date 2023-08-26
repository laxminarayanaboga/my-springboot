package com.example.demo.dao;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findAllSortByLastName() {
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);
        return typedQuery.getResultList();

    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        typedQuery.setParameter("theData", theLastName);

        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void updateStudentsEmailByMatchingGivenLastName(String theLastName) {
        Query query = entityManager.createQuery("UPDATE Student SET email=:theEmail WHERE lastName=:theLastName");
        query.setParameter("theEmail", "someNewEmailv2@asdf.com.invalid");
        query.setParameter("theLastName", theLastName);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteStudentsBasedOnLastName(String theLastName) {
        Query query = entityManager.createQuery("DELETE FROM Student WHERE lastName=:theLastName");
        query.setParameter("theLastName", theLastName);
        return query.executeUpdate();
    }
}
