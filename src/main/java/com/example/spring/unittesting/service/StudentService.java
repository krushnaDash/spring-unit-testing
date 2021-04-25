package com.example.spring.unittesting.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.unittesting.model.Student;
import com.example.spring.unittesting.model.StudentView;
import com.example.spring.unittesting.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	Logger log= LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Here the logic to find the happy student is
	 * find the student which age match to age which has more student and name is Test2 
	 * @return Student
	 */
	public Student getHappyStudent(int std) {
		log.info("method called : getHappyStudent()" );
		int maxStudent = 0;
		int age = 0;
		List<StudentView> students = studentRepository.findStudentsByNativeQuery(std);
		for (StudentView student : students) {
			if (student.getCount() > maxStudent) {
				maxStudent = student.getCount();
				age = student.getAge();
			}
		}
		List<Student> happyStudents = studentRepository.findStudentsByAgeAndStd(1, age);
		return happyStudents.stream().filter(s -> s.getName().equals("Test2")).collect(Collectors.toList()).get(0);

	}

}
