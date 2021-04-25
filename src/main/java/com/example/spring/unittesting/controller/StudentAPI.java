package com.example.spring.unittesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.spring.unittesting.model.Student;
import com.example.spring.unittesting.service.StudentService;

@Controller
public class StudentAPI {

	@Autowired
	StudentService studentService;

	@GetMapping("student/happy-student/{std}")
	public ResponseEntity<Student> getHappyStudent(@PathVariable int std) {
		return ResponseEntity.ok(studentService.getHappyStudent(std));
	}
}
