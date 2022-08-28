package com.register.spring_boot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Register {
    private long register_id;
    private int student, subject;


    public Register() {
    }

    public Register(long register_id, int student, int subject) {
        this.register_id = register_id;
        this.student = student;
        this.subject = subject;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getRegister_id() {
        return this.register_id;
    }

    public void setRegister_id(long register_id) {
        this.register_id = register_id;
    }

    @ManyToOne
    @JoinColumn(name = "student_id")
    public int getStudent() {
        return this.student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name = "subject_id")
    public int getSubject() {
        return this.subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public Register register_id(long register_id) {
        setRegister_id(register_id);
        return this;
    }

    public Register student(int student) {
        setStudent(student);
        return this;
    }

    public Register subject(int subject) {
        setSubject(subject);
        return this;
    }
}
