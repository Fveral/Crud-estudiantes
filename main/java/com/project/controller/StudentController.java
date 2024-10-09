package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.model.Student;
import com.project.service.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping({ "/students", "/" })
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.listStudents());
        return "students";
    }

    @GetMapping("/student/create")
    public String mostrarFormularioStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/student")
    public String createStudent(@ModelAttribute("student") Student student) {
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/student/edit/{id}")
    public String formEdit(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "editar_student";
    }

    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        Student studentExist = studentService.findById(id);
        studentExist.setIdStudent(id);
        studentExist.setName(student.getName());
        studentExist.setLastName(student.getLastName());
        studentExist.setEmail(student.getEmail());
        studentService.updateStudent(studentExist);
        return "redirect:/students";
    }

    @GetMapping ("/student/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
