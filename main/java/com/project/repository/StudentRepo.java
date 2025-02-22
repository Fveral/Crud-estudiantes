package com.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    
}
