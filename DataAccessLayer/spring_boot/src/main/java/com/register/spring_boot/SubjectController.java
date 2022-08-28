package com.register.spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SubjectController {
    @Autowired
    private SubjectService service;
     
    @RequestMapping("/api/getAllSubject")
    public List<Subject> listAll() {
        return service.listAll();
    }
     
    @RequestMapping("/api/saveSubject")
    public void save(Subject admin) {
        service.save(admin);
    }
     
    @RequestMapping("/api/getSubject")
    public Subject get(long id) {
        return service.get(id);
    }
     
    @RequestMapping("/api/deleteSubject")
    public void delete(long id) {
        service.delete(id);
    }    
}