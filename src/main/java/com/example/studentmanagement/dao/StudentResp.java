package com.example.studentmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagement.model.*;

public interface StudentResp extends JpaRepository<Student, Integer>{

}
