package com.example.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.studentmanagement.model.RecentStudentList;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.*;

@Controller
public class StudentController {
		@Autowired
		private StudentService service;
		
		@Autowired
		private RecentStudentListService recentStudentService;
		
		@GetMapping("/")
		public String home() {
			return "home";
		}
		
		@GetMapping("/student_register")
		public String studentRegister() {
			return "studentRegister";
		}
		
		@GetMapping("/available_students")
		public ModelAndView getAllStudent() {
			List<Student>list=service.getAllStudent();
//			ModelAndView m=new ModelAndView();
//			m.setViewName("bookList");
//			m.addObject("book",list);
			return new ModelAndView("studentList","student",list);
		}
		
		@PostMapping("/save")
		public String addStudent(@ModelAttribute Student s) {
			service.save(s);
			return "redirect:/available_students";
		}
		
		@GetMapping("/recent_students")
		public String getRecentStudents(Model model)
		{
			List<RecentStudentList>list=recentStudentService.getAllRecentStudents();
			model.addAttribute("student",list);
			return "recentstudents";
		}
		@RequestMapping("/recentlist/{id}")
		public String getRecentList(@PathVariable("id") int id) {
			Student s=service.getStudentById(id);
			RecentStudentList rs=new RecentStudentList(s.getId(),s.getName(),s.getEmail(),s.getCourse(),s.getFee(),s.getPaid(),s.getDue(),s.getAddress(),s.getCity(),s.getState(),s.getCountry(),s.getContactno());
			recentStudentService.saveRecentStudents(rs);
			return "redirect:/recent_students";
		}
		
		@RequestMapping("/editStudent/{id}")
		public String editStudent(@PathVariable("id") int id,Model model) {
			Student s=service.getStudentById(id);
			model.addAttribute("student",s);
			return "studentEdit";
		}
		@RequestMapping("/deleteStudent/{id}")
		public String deleteStudent(@PathVariable("id")int id) {
			service.deleteById(id);
			return "redirect:/available_students";
		}
		
}
