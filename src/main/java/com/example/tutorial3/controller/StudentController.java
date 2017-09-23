package com.example.tutorial3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.tutorial3.model.StudentModel;
import com.example.tutorial3.service.InMemoryStudentService;
import com.example.tutorial3.service.StudentService;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
	private final StudentService studentService;
	
	public StudentController() {
		studentService = new InMemoryStudentService();
	}
	
	@RequestMapping("/student/add")
	public String add(@RequestParam(value = "npm", required = true) String npm,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "gpa", required = true) double gpa) {
		StudentModel student = new StudentModel(npm, name, gpa);
		studentService.addStudent(student);
		return "add";
	}
	
//	@RequestMapping("/student/view")
//	public String view(Model model, @RequestParam(value = "npm", required = true) String npm) {
//		StudentModel student = studentService.selectStudent(npm);
//		model.addAttribute("student", student);
//		return "view";
//	}
	
	@RequestMapping("/student/viewall")
	public String viewAll(Model model) {
		List<StudentModel> students = studentService.selectAllStudents();
		System.out.println("haha");
		System.out.println(students);
		model.addAttribute("students", students);
		return "viewall";
	}
	
	@RequestMapping(value = {"/student/view", "/student/view/{npm}"})
	public String viewPath(Model model, @PathVariable Optional<String> npm) {
		if (npm.isPresent()) {
			StudentModel student = studentService.selectStudent(npm.get());
			model.addAttribute("student", student);
			if (student == null) {
				return "error_notFound";
			}
			return "view";
		}
		return "error_null";
	}
	
	@RequestMapping(value = {"/student/delete", "/student/delete/{npm}"})
	public String deletePath(Model model, @PathVariable Optional<String> npm) {
		if (npm.isPresent()) {
			StudentModel student = studentService.selectStudent(npm.get());
			if (student == null) {
				return "error_notFound";
			}
			model.addAttribute("studentName", student.getName());
			model.addAttribute("studentNpm", student.getNpm());
			model.addAttribute("studentGpa", student.getGpa());
			return "delete";
		}
		return "error_null";
	}
}
