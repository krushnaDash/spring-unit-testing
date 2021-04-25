package com.example.spring.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.spring.unittesting.model.Student;
import com.example.spring.unittesting.service.StudentService;

@WebMvcTest(StudentAPI.class)
@ExtendWith(SpringExtension.class)
class StudentAPITest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	@Test
	void getHappyStudentTest() throws Exception {
		Mockito.when(studentService.getHappyStudent(Mockito.anyInt())).thenReturn(new Student("Test", 5, 1));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/student/happy-student/1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(
						MockMvcResultMatchers.content().json("{\"studentId\":0,\"name\":\"Test\",\"age\":5,\"std\":1}"))
				.andReturn();

	}

}
