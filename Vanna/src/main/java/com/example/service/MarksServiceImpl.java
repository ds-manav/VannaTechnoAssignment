package com.example.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.Marks;
import com.example.dao.Student;
import com.example.dao.MarksRepository;

@Service
public class MarksServiceImpl implements MarksService {
	@Autowired
	MarksRepository marksrepo;

	@Override
	public List<Marks> getAllMarks() {
		List<Marks> m = marksrepo.findAll();
		return m;
	}

	@Override
	public Optional<Marks> getMarksById(Integer i) {
		Optional<Marks>  m= marksrepo.findById(i);
		return m;
	}

	@Override
	public Marks saveMarks(Marks s) {
		Marks m = marksrepo.save(s);
		return m;
	}

	@Override
	public Marks updateMarksById(Marks m) {
		Optional<Marks> m1 = marksrepo.findById(m.getMarksid());
		if((m1.get().getSubject1())!=(m.getSubject1()) && m.getSubject1() !=0) {
			m1.get().setSubject1(m.getSubject1());
		}
		
		if((m1.get().getSubject2())!=(m.getSubject2()) && m.getSubject2() !=0) {
			m1.get().setSubject1(m.getSubject2());
		}
		
		if((m1.get().getSubject3())!=(m.getSubject3()) && m.getSubject3() !=0) {
			m1.get().setSubject3(m.getSubject3());
		}
		
		if((m1.get().getSubject4())!=(m.getSubject4()) && m.getSubject4() !=0) {
			m1.get().setSubject4(m.getSubject4());
		}
		marksrepo.save(m1.get());
		
		return m1.get();
	}
	

	@Override
	public void deleteMarks(Marks s) {
		marksrepo.delete(s);
	}

	@Override
	public Float studentPercent(Integer id) {
		float per = marksrepo.percentage(id);
		return per;
	}

	
}
