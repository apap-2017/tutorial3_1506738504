package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Student;

public class InMemoryStudentService implements StudentService {
	
	private static List<Student> studentList = new ArrayList<>();
	@Override
	public Student selectStudent(String npm) {
		// TODO Auto-generated method stub
		for(Student s : studentList){
			if(s.getNpm().equals(npm)){
				return s;
			}
		}
		return null;
	}

	@Override
	public List<Student> selectAllStudents() {
		// TODO Auto-generated method stub
		return studentList;
	}

	@Override
	public void addStudent(Student student) {
		studentList.add(student);
		
	}

}
