package com.register.spring_boot;

 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class RegisterService {
    @Autowired
    private RegisterRepository repo;
     
    public List<Register> listAll() {
        return repo.findAll();
    }
     
    public void save(Register register) {
        repo.save(register);
    }
     
    public Register get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
