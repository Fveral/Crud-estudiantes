package com.project.service;
import java.util.List;
import com.project.model.Student;

public interface StudentService {
    List<Student> listStudents();
    Student createStudent(Student student);
    Student findById(Long id);
    Student updateStudent(Student student);
    void deleteStudent(Long id);

}
