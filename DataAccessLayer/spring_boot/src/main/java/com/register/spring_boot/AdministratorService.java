package com.register.spring_boot;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class AdministratorService {
    @Autowired
    private AdministratorRepository repo;
     
    public List<Administrator> listAll() {
        return repo.findAll();
    }
     
    public void save(Administrator admin) {
        repo.save(admin);
    }
     
    public Administrator get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
