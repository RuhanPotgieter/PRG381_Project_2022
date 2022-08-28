package com.register.spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    @Autowired
    private RegisterService service;
     
    @RequestMapping("/api/getAllRegister")
    public List<Register> listAll() {
        return service.listAll();
    }
     
    @RequestMapping("/api/saveRegister")
    public void save(Register admin) {
        service.save(admin);
    }
     
    @RequestMapping("/api/getRegister")
    public Register get(long id) {
        return service.get(id);
    }
     
    @RequestMapping("/api/deleteRegister")
    public void delete(long id) {
        service.delete(id);
    }
}