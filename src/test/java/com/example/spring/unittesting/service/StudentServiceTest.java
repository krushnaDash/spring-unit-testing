package com.example.spring.unittesting.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.spring.unittesting.model.Student;
import com.example.spring.unittesting.model.StudentView;
import com.example.spring.unittesting.repository.StudentRepository;


@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
	
	@Mock
	StudentRepository studentRepository;
	
	@InjectMocks
	StudentService StudentService;
	
	
	
	@Test
	void getHappyStudentTest() {
		StudentView studentView = Mockito.mock(StudentView.class);
		Mockito.when(studentView.getCount()).thenReturn(2);
		Mockito.when(studentView.getAge()).thenReturn(5);
	
		List<StudentView> values = new ArrayList<>();
		values.add(studentView);
	
		List<Student> students = new ArrayList<>();
		students.add(new Student("Test2", 5, 1));
	
		Mockito.when(studentRepository.findStudentsByNativeQuery(Mockito.anyInt())).thenReturn(values);
		Mockito.when(studentRepository.findStudentsByAgeAndStd(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(students);
		Student student = StudentService.getHappyStudent(1);
		Assertions.assertThat(student.getAge()).isEqualTo(5);
	
	}
}
