package com.sol.sms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sol.sms.entity.Student;
import com.sol.sms.service.StudentService;

@RestController
@RequestMapping("/api/students")   // ← THIS IS THE IMPORTANT PART!
public class StudentRestController {

    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET /api/students → all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    // GET /api/students/5 → one student
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Student student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    // POST /api/students → create new
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        student.setId(null); // ensure it's a new record
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // PUT /api/students/5 → update
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        student.setId(id);
        studentService.save(student);
        return ResponseEntity.ok(student);
    }

    // DELETE /api/students/5 → delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
