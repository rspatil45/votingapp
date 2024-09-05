package com.rspatil45.votingapp.dao;

import com.rspatil45.votingapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;

@Repository
@Persistent
public class StudentDAOImpl implements StudentDAO {
    private final EntityManager entityManager;
    private final Session session;
    @Autowired
    public StudentDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
        this.session = entityManager.unwrap(Session.class);
    }
    @Override
    @Transactional
    public Student findStudentByStudentName(String studentName) {
        Query<Student> query = session.createQuery("FROM Student where studentName = :name", Student.class);
        query.setParameter("name", studentName);
        Student student = query.getResultList().get(0);
        return student;
    }
    @Transactional
    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

}
