package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.model.Student;
import com.project.repository.StudentRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo repo;

    @Override
    public List<Student> listStudents() {
        return repo.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public Student findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

}
