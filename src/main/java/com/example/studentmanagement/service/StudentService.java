package com.example.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.studentmanagement.model.*;
import com.example.studentmanagement.dao.*;



@Service
public class StudentService {

	@Autowired
	private StudentResp sr;
	
	public void save(Student s) {
		sr.save(s);
	}
	
	public List<Student> getAllStudent(){
		return sr.findAll();
	}
	
	public Student getStudentById(int id) {
		return sr.findById(id).get();
	}
	public void deleteById(int id) {
		sr.deleteById(id);
	}
}


		
		

