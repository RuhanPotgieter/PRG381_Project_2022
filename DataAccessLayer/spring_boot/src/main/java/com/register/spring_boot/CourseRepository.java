package com.register.spring_boot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository  extends JpaRepository<Course, Long> {
    
}
