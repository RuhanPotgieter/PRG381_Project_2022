package com.register.spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;
     
    @RequestMapping("/api/getAllStudent")
    public List<Student> listAll() {
        return service.listAll();
    }
     
    @RequestMapping("/api/saveStudent")
    public void save(Student admin) {
        service.save(admin);
    }
     
    @RequestMapping("/api/getStudent")
    public Student get(long id) {
        return service.get(id);
    }
     
    @RequestMapping("/api/deleteStudent")
    public void delete(long id) {
        service.delete(id);
    }
}