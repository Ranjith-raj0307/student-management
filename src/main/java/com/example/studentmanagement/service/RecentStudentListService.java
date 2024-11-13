package com.example.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.dao.*;
import com.example.studentmanagement.model.*;

@Service
public class RecentStudentListService {

	@Autowired
	private RecentStudentResp recentstudent;
	
	public void saveRecentStudents(RecentStudentList student) {
		recentstudent.save(student);
	}
	
	public List<RecentStudentList> getAllRecentStudents(){
		return recentstudent.findAll();
	}
	
	public void deleteById(int id) {
		recentstudent.deleteById(id);
	}
}
