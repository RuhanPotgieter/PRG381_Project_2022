package com.register.spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CourseController {
    @Autowired
    private CourseService service;
     
    public List<Course> listAll() {
        return service.listAll();
    }
     
    public void save(Course admin) {
        service.save(admin);
    }
     
    public Course get(long id) {
        return service.get(id);
    }
     
    public void delete(long id) {
        service.delete(id);
    }
}
