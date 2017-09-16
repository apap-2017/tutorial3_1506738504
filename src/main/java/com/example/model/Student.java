package com.example.model;


public class Student {
	private String name;
	private String npm;
	private double gpa;
	
	public Student(String npm, String name, double gpa){
		this.name = name;
		this.npm = npm;
		this.gpa = gpa;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getNpm(){
		return this.npm;
	}
	
	public double getGpa(){
		return this.gpa;
	}
}
