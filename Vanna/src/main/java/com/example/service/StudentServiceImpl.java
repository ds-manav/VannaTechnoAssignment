package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.Student;
import com.example.dao.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentrepo;

	@Override
	public List<Student> getAllStudent() {
		List<Student> s = studentrepo.findAll();
		return s;
	}

	@Override
	public Optional<Student> getStudentById(Integer i) {

		Optional<Student> s = studentrepo.findById(i);
		return s;
	}

	@Override
	public Student saveStudent(Student s) {
		Student s1 = studentrepo.save(s);
		return s1 ;
	}

	@Override
	public Student updateStudentById(Student s) {
		Optional<Student> s1 = studentrepo.findById(s.getStudentid());
		if(!s1.get().getStudentname().equals(s.getStudentname()) && s.getStudentname() != null && !s.getStudentname().equals("")) {
			s1.get().setStudentname(s.getStudentname());
		}
		
		if(!s1.get().getStudentstream().equals(s.getStudentstream()) && s.getStudentstream() != null && !s.getStudentstream().equals("")) {
			s1.get().setStudentstream(s.getStudentstream());
		}
		studentrepo.save(s1.get());
		return s1.get();
	}

	@Override
	public void deleteStudent(Student s) {
		Integer i = s.getStudentid();
		studentrepo.deleteById(i);
		
	}

//	@Override
//	public Float studentPercent(Integer id) {
//		float per = studentrepo.percentage(id);
//		return per;
//	}
	
	

}
