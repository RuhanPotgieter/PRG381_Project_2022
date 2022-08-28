package com.register.spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {
    @Autowired
    private CourseService service;
    
    @RequestMapping("/api/getAllCourse")
    public List<Course> listAll() {
        return service.listAll();
    }
     
    @RequestMapping("/api/saveCourse")
    public void save(Course admin) {
        service.save(admin);
    }
     
    @RequestMapping("/api/getCourse")
    public Course get(long id) {
        return service.get(id);
    }
     
    @RequestMapping("/api/deleteCourse")
    public void delete(long id) {
        service.delete(id);
    }
}


