package com.example.spring.unittesting.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.spring.unittesting.model.Student;
import com.example.spring.unittesting.model.StudentView;

@Repository("StudentRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query(value = "select age, count(name) as count from student " + "where std = ?1 group by age"
			+ " order by age", nativeQuery = true)
	public List<StudentView> findStudentsByNativeQuery(int std);
	
	
	@Query(value = "select * from student " + "where std = ?1 and age =?2"
			+ " order by student_id", nativeQuery = true)
	public List<Student> findStudentsByAgeAndStd(int std, int age);

	public Optional<Student> findById(Long id);

}