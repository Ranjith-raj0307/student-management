package com.example.studentmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagement.model.*;


public interface RecentStudentResp extends JpaRepository<RecentStudentList,Integer>{

}
