package com.sol.sms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sol.sms.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
}