package com.register.spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SubjectController {
    @Autowired
    private SubjectService service;
     
    public List<Subject> listAll() {
        return service.listAll();
    }
     
    public void save(Subject admin) {
        service.save(admin);
    }
     
    public Subject get(long id) {
        return service.get(id);
    }
     
    public void delete(long id) {
        service.delete(id);
    }    
}
