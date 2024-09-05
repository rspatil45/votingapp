package com.rspatil45.votingapp.dao;

import com.rspatil45.votingapp.entity.Student;

public interface StudentDAO {
    Student findStudentByStudentName(String studentName);
    void updateStudent(Student student);
}
