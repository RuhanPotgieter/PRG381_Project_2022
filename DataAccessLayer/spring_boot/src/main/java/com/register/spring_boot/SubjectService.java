package com.register.spring_boot;

public class SubjectService {
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
