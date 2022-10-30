package com.example.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Marks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer marksid;
	
	private Integer Subject1;

	private Integer Subject2;
	
	private Integer Subject3;	
	
	private Integer Subject4;
	
	private Integer totalmarks = 400;
	
	
	
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "student")
  @JsonBackReference
  private Student student;




	


	public Integer getMarksid() {
		return this.marksid;
	}
	

	public Marks(Integer subject1, Integer subject2, Integer subject3, Integer subject4, Integer totalmarks) {
		this.Subject1 = subject1;
		this.Subject2 = subject2;
		this.Subject3 = subject3;
		this.Subject4 = subject4;
		this.totalmarks = totalmarks;
		
	}
	
	public Marks(Student student) {
		super();
		this.student = student;
	}


	public Marks() {};


	@Override
	public String toString() {
		return "Marks [marksid=" + marksid + ", Subject1=" + Subject1 + ", Subject2=" + Subject2 + ", Subject3="
				+ Subject3 + ", Subject4=" + Subject4 + ", totalmarks=" + totalmarks + ", student=" + student + "]";
	}


	public void setMarksid(Integer marksid) {
		this.marksid = marksid;
	}
	


	public int getSubject1() {
		return Subject1;
	}

	public void setSubject1(Integer subject1) {
		this.Subject1 = subject1;
	}

	public int getSubject2() {
		return Subject2;
	}

	public void setSubject2(Integer subject2) {
		this.Subject2 = subject2;
	}

	public int getSubject3() {
		return Subject3;
	}

	public void setSubject3(Integer subject3) {
		this.Subject3 = subject3;
	}

	public int getSubject4() {
		return Subject4;
	}

	public void setSubject4(Integer subject4) {
		this.Subject4 = subject4;
	}

	public int getTotalmarks() {
		return totalmarks;
	}

	public void setTotalmarks(Integer totalmarks) {
		this.totalmarks = totalmarks;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	
	

}
