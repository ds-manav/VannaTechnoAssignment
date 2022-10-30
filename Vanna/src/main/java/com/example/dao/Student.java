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

import com.example.dao.Marks;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer studentid;
	private String studentname;
	
	private String studentstream;
	

	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	@JsonManagedReference
    private Marks marks;
	
    public Student(){};

	public int getStudentid() {
		return studentid;
	}

	
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentname=" + studentname + ", studentstream=" + studentstream
				+ ", marks=" + marks + "]";
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public Student(com.example.dao.Marks marks) {
		super();
		this.marks = marks;
	}
	



	public String getStudentname() {
		return studentname;
	}

	public Student(String studentname, String studentstream) {
		super();
		this.studentname = studentname;
		this.studentstream = studentstream;
	}


	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentstream() {
		return studentstream;
	}

	public void setStudentstream(String studentstream) {
		this.studentstream = studentstream;
	}

	public Student( String studentname, String studentstream,Marks mark) {
	
		this.studentname = studentname;
		this.studentstream = studentstream;
		this.marks = mark;
	}

	public Marks getMarks() {
		return this.marks;
	}

	public void setMarks(Marks marks) {
		
		this.marks = marks;
	}
//	
	

}
