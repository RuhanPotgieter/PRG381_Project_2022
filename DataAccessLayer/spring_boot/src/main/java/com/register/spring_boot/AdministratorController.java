package com.register.spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdministratorController {
    @Autowired
    private AdministratorService service;
    
    @RequestMapping("/api/getAllAdmin")
    public List<Administrator> listAll() {
        return service.listAll();
    }
    
    @RequestMapping("/api/saveAdmin")
    public void save(Administrator admin) {
        service.save(admin);
    }
    
    @RequestMapping("/api/getAdmin")
    public Administrator get(long id) {
        return service.get(id);
    }
     
    @RequestMapping("/api/deleteAdmin")
    public void delete(long id) {
        service.delete(id);
    }
}
