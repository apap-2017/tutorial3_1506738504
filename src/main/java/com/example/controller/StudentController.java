package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.InMemoryStudentService;
import com.example.service.StudentService;

import groovyjarjarantlr.collections.List;

import com.example.model.Student;

@Controller
public class StudentController {
	private final InMemoryStudentService studentMapper;
	
	public StudentController(){
		studentMapper = new InMemoryStudentService();
	}
	
	@RequestMapping("/student/add")
	public String add(
	@RequestParam(value = "npm", required = true) String npm,
	@RequestParam(value = "name",required = true) String name,
	@RequestParam(value = "gpa", required = true) double gpa) {
		Student student = new Student(npm, name, gpa);
		studentMapper.addStudent(student);
		return "add";
	}
	
	@RequestMapping("/student")
	public String studentAll(Model model){
		model.addAttribute("students", studentMapper.selectAllStudents());
		
		return "students";
	}
	@RequestMapping("/student/{npm}")
	public String student(@PathVariable String npm, Model model){
		Student s = studentMapper.selectStudent(npm);
		model.addAttribute("student", s);
		return "student";
	}
}
