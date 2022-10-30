package com.example.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dao.Marks;
import com.example.dao.Student;

@Service
public interface MarksService {
	
	public List<Marks> getAllMarks();
	public Optional<Marks> getMarksById(Integer i);
	public Marks saveMarks(Marks s);
	public Marks updateMarksById(Marks s);
	public void deleteMarks(Marks s);
	public Float studentPercent(Integer id);

}
