package com.example.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.studentmanagement.service.*;


@Controller
public class RecentStudentListController {
	@Autowired
	private RecentStudentListService service;
	
	@RequestMapping("/deleteRecentList/{id}")
	public String deleteRecentList(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/recent_students";
	}
}
