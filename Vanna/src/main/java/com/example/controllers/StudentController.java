package com.example.controllers;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customhttpeaders.HttpGenerator;
import com.example.service.StudentService;
import com.example.service.StudentServiceImpl;
//import com.teamb.dao.Marks;
import com.example.dao.Student;

@RestController
@RequestMapping("api")
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	
	@Autowired
	private HttpGenerator httpgenerator;
	
	@PostMapping(path ="/student")
	public ResponseEntity<Student> postdata (@RequestBody Student m ,HttpServletRequest request) {
		if(m != null) {
		
		try {
			Student s = studentservice.saveStudent(m);
			String name = s.getStudentname();
			return new ResponseEntity<Student>(s,httpgenerator.getHeadersForSuccessPostMethod(request, name),HttpStatus.OK);
			
		}
		catch(Exception e) {
			return new ResponseEntity<Student>(httpgenerator.getHeadersForError(),HttpStatus.BAD_REQUEST);
		}
		}
		else{
			return new ResponseEntity<Student>(httpgenerator.getHeadersForError(),HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudent(){
		try {
			List<Student> s = studentservice.getAllStudent();
			return new ResponseEntity<List<Student>>(s,httpgenerator.getHeadersForSuccessGetMethod(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<Student>>(httpgenerator.getHeadersForError(),HttpStatus.METHOD_FAILURE);
		}
		
	}
	
	@GetMapping("student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
		if(id!=null) {
		try {
			Optional<Student> s = studentservice.getStudentById(id);
			return new ResponseEntity<Student>(s.get(),httpgenerator.getHeadersForSuccessGetMethod(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Student>(httpgenerator.getHeadersForError(),HttpStatus.METHOD_FAILURE);
		}
		}
		else {
			return new ResponseEntity<Student>(httpgenerator.getHeadersForError(),HttpStatus.NO_CONTENT);
		}
		
	}
	
	

	@PutMapping("/student")
	public ResponseEntity<Student> updateStudentDetails(@RequestBody Student s,HttpServletRequest request){
		if(s!=null) {
			try {
			Student s1 = studentservice.updateStudentById(s);
				return new ResponseEntity<Student>(s1,httpgenerator.getHeadersForSuccessPostMethod(request, s.getStudentname()),HttpStatus.OK);
				}
			catch(Exception e) {
				return new ResponseEntity<Student>(httpgenerator.getHeadersForError(),HttpStatus.METHOD_FAILURE);
			}
		}
			else {
				return new ResponseEntity<Student>(httpgenerator.getHeadersForSuccessGetMethod(),HttpStatus.BAD_REQUEST);
			}
		}
	
	@DeleteMapping("student/{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable("id") Integer id){
		if(id!=null) {
		try {
			Optional<Student> s = studentservice.getStudentById(id);
			studentservice.deleteStudent(s.get());
			return new ResponseEntity<String>("Deleted",HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Failed",HttpStatus.METHOD_FAILURE);
		}
		}
		else {
			return new ResponseEntity<String>("Failed",HttpStatus.NOT_FOUND);
			
		}
	}
	
//	
	}
	

