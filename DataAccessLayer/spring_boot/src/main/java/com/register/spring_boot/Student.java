package com.register.spring_boot;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Student {
    private long student_id;
    private String student_name, student_surname, student_address, student_email, student_password;
    private int student_course;

    
    public Student() {
    }

    public Student(long student_id, String student_name, String student_surname, String student_address, String student_email, String student_password, int student_course) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_surname = student_surname;
        this.student_address = student_address;
        this.student_email = student_email;
        this.student_password = student_password;
        this.student_course = student_course;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getStudent_id() {
        return this.student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return this.student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_surname() {
        return this.student_surname;
    }

    public void setStudent_surname(String student_surname) {
        this.student_surname = student_surname;
    }

    public String getStudent_address() {
        return this.student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public String getStudent_email() {
        return this.student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_password() {
        return this.student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    @ManyToOne
    @JoinColumn(name = "course_id")
    public int getStudent_course() {
        return this.student_course;
    }

    public void setStudent_course(int student_course) {
        this.student_course = student_course;
    }

    public Student student_id(long student_id) {
        setStudent_id(student_id);
        return this;
    }

    public Student student_name(String student_name) {
        setStudent_name(student_name);
        return this;
    }

    public Student student_surname(String student_surname) {
        setStudent_surname(student_surname);
        return this;
    }

    public Student student_address(String student_address) {
        setStudent_address(student_address);
        return this;
    }

    public Student student_email(String student_email) {
        setStudent_email(student_email);
        return this;
    }

    public Student student_password(String student_password) {
        setStudent_password(student_password);
        return this;
    }

    public Student student_course(int student_course) {
        setStudent_course(student_course);
        return this;
    }

    @OneToMany(mappedBy = "student")
    private Set<Register> recordings = new HashSet<>();
}