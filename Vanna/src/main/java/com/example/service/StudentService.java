package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dao.Student;

@Service
public interface StudentService {
	
	public List<Student> getAllStudent();
	public Optional<Student> getStudentById(Integer i);
	public Student saveStudent(Student s);
	public Student updateStudentById(Student s);
	public void deleteStudent(Student s);
//	public Float studentPercent(Integer id);
	

}
