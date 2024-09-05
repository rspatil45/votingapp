package com.rspatil45.votingapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql manage value of id (auto increment)
    @Column(name = "student_id")
    private int student_id;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "has_voted")
    private boolean hasVoted=false;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", studentName='" + studentName + '\'' +
                ", hasVoted=" + hasVoted +
                '}';
    }
}
