package com.sol.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sol.sms.entity.Student;
import com.sol.sms.repo.StudentRepository;
@Service
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();  // <-- NO CAST
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);  // <-- NO CAST
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);  // <-- NO CAST
    }
}
