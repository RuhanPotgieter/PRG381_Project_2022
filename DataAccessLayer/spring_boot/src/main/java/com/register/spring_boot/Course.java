package com.register.spring_boot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
    private long course_id;
    private String course_name;
    private double tuition;

    @OneToMany(mappedBy = "student_course")

    public Course() {
    }

    public Course(long course_id, String course_name, double tuition) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.tuition = tuition;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return this.course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public double getTuition() {
        return this.tuition;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public Course course_id(long course_id) {
        setCourse_id(course_id);
        return this;
    }

    public Course course_name(String course_name) {
        setCourse_name(course_name);
        return this;
    }

    public Course tuition(double tuition) {
        setTuition(tuition);
        return this;
    }
}
