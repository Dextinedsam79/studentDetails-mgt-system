package com.sol.sms.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sol.sms.entity.Student;
import com.sol.sms.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "studentlist";   // → templates/list-students.html
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("student", new Student());
        return "studentform";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable Integer id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "studentform";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/students/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteById(id);
        return "redirect:/students/list";
    }
}
