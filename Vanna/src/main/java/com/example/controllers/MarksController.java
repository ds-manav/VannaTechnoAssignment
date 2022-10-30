package com.example.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.customhttpeaders.HttpGenerator;
import com.example.dao.Marks;
import com.example.dao.Student;
import com.example.service.MarksService;
import com.example.service.MarksServiceImpl;

@RestController
@RequestMapping("api")
public class MarksController {
	
	@Autowired
	MarksService marksservice;
	
	@Autowired
	HttpGenerator httpgenerator;
	
	@PostMapping(path="/marks",consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces =  org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Marks> postMarks(@RequestBody Marks m , HttpServletRequest request){
		if(m != null) {
			
			try {
				Marks s = marksservice.saveMarks(m);
				String  name = "";
				return new ResponseEntity<Marks>(s,httpgenerator.getHeadersForSuccessPostMethod(request, name),HttpStatus.OK);
				
			}
			catch(Exception e) {
				return new ResponseEntity<Marks>(httpgenerator.getHeadersForError(),HttpStatus.BAD_REQUEST);
			}
			}
			else{
				return new ResponseEntity<Marks>(httpgenerator.getHeadersForError(),HttpStatus.NO_CONTENT);
			}

	}
	
	@GetMapping("/marks")
	public @ResponseBody ResponseEntity<List<Marks>> getAllStudent(){
		
		try {
			List<Marks> s = marksservice.getAllMarks();
			return new ResponseEntity<List<Marks>>(s,httpgenerator.getHeadersForSuccessGetMethod(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<Marks>>(httpgenerator.getHeadersForError(),HttpStatus.METHOD_FAILURE);
		}
		
	}
	
	@GetMapping("marks/{id}")
	public @ResponseBody ResponseEntity<Marks> getStudentById(@PathVariable Integer id){
		if(id!=null) {
		try {
			Optional<Marks> s = marksservice.getMarksById(id);
			return new ResponseEntity<Marks>(s.get(),httpgenerator.getHeadersForSuccessGetMethod(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Marks>(httpgenerator.getHeadersForError(),HttpStatus.METHOD_FAILURE);
		}
		}
		else {
			return new ResponseEntity<Marks>(httpgenerator.getHeadersForError(),HttpStatus.NO_CONTENT);
		}
		
	}

	@PutMapping("/marks")
	public ResponseEntity<Marks> updateStudentDetails(@RequestBody Marks s,HttpServletRequest request){
		if(s!=null) {
			try {
			Marks s1 = marksservice.updateMarksById(s);
				return new ResponseEntity<Marks>(s1,httpgenerator.getHeadersForSuccessPostMethod(request, (s.getMarksid()+"a")),HttpStatus.OK);
				}
			catch(Exception e) {
				return new ResponseEntity<Marks>(httpgenerator.getHeadersForError(),HttpStatus.METHOD_FAILURE);
			}
		}
			else {
				return new ResponseEntity<Marks>(httpgenerator.getHeadersForSuccessGetMethod(),HttpStatus.BAD_REQUEST);
			}
		}
	
	@DeleteMapping("marks/{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable("id") Integer id){
		if(id!=null) {
		try {
			Optional<Marks> s = marksservice.getMarksById(id);
			marksservice.deleteMarks(s.get());
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
	
	@GetMapping("percent/{id}")
	public ResponseEntity<?> getpercent(@PathVariable Integer id){
		try {
			float per = marksservice.studentPercent(id);
			return new ResponseEntity<Float>(per,httpgenerator.getHeadersForSuccessGetMethod(),HttpStatus.OK);
		}
		
		catch(Exception e){
			return new ResponseEntity<Float>(httpgenerator.getHeadersForError(),HttpStatus.METHOD_FAILURE);
		}
		
		
	}


	
	

}
