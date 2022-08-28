package com.register.spring_boot;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class SubjectService{
  
    @Autowired
    private SubjectRepository repo;
     
    public List<Subject> listAll() {
        return repo.findAll();
    }
     
    public void save(Subject subject) {
        repo.save(subject);
    }
     
    public Subject get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
