package com.register.spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdministratorController {
    @Autowired
    private AdministratorService service;
     
    public List<Administrator> listAll() {
        return service.listAll();
    }
     
    public void save(Administrator admin) {
        service.save(admin);
    }
     
    public Administrator get(long id) {
        return service.get(id);
    }
     
    public void delete(long id) {
        service.delete(id);
    }
}
