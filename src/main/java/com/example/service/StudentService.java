package com.example.service;
import java.util.List;
import com.example.model.Student;

public interface StudentService {

	Student selectStudent (String npm);
	List<Student> selectAllStudents();
	void addStudent (Student student);

}