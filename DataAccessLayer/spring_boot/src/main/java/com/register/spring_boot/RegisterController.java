package com.register.spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RegisterController {
    @Autowired
    private RegisterService service;
     
    public List<Register> listAll() {
        return service.listAll();
    }
     
    public void save(Register admin) {
        service.save(admin);
    }
     
    public Register get(long id) {
        return service.get(id);
    }
     
    public void delete(long id) {
        service.delete(id);
    }
}
