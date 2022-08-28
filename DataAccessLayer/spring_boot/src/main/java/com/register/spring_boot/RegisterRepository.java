package com.register.spring_boot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register, Long> {
    
}
