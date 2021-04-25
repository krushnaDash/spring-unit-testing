package com.example.spring.unittesting.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.spring.unittesting.model.Student;
import com.example.spring.unittesting.model.StudentView;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRepository;

	@Test
	void findStudentsByNativeQuery() {
		List<StudentView> studetnsview = studentRepository.findStudentsByNativeQuery(1);
		Assertions.assertThat(studetnsview).hasSize(4);
		Assertions.assertThat(studetnsview.get(0).getCount()).isBetween(0, 10);
	}
	
	@Test
	void findStudentsByIdTest() {
		Optional<Student> student = studentRepository.findById(1L);
		Assertions.assertThat(student.get().getName()).contains("Test1");
	}
	
	@Test
	void findStudentsByAgeAndStdTest() {
	List<Student> students=	studentRepository.findStudentsByAgeAndStd(1, 5);
	Assertions.assertThat(students).hasSize(3);
	Assertions.assertThat(students.get(2).getName()).isEqualTo("Test3");
		
	}

}
