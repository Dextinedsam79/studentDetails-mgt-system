package com.sol.sms.service;

import java.util.List;

import com.sol.sms.entity.Student;

public interface IStudentService {
	List<Student> findAll();
    Student findById(Integer id);
    void save(Student student);
    void deleteById(Integer id);

}
