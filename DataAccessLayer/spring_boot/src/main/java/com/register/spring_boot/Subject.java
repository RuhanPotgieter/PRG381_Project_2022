package com.register.spring_boot;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Subject {
    private long subject_id;
    private String subject_name;

    
    public Subject() {
    }

    public Subject(long subject_id, String subject_name) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getSubject_id() {
        return this.subject_id;
    }

    public void setSubject_id(long subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return this.subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public Subject subject_id(long subject_id) {
        setSubject_id(subject_id);
        return this;
    }

    public Subject subject_name(String subject_name) {
        setSubject_name(subject_name);
        return this;
    }

    @OneToMany(mappedBy = "subject")
    private Set<Register> recordings = new HashSet<>();
}
