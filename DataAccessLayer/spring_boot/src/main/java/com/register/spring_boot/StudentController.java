package com.register.spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;
     
    public List<Student> listAll() {
        return service.listAll();
    }
     
    public void save(Student admin) {
        service.save(admin);
    }
     
    public Student get(long id) {
        return service.get(id);
    }
     
    public void delete(long id) {
        service.delete(id);
    }
}
