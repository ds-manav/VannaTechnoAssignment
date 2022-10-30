package com.example.dao;


import javax.persistence.NamedStoredProcedureQueries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{

//@Query("Select ((m.Subject1 + m.Subject2 + m.Subject3 + m.Subject4)/m.totalmarks)*100 from Student  s join Marks  m on s.studentid = m.studentid where m.studentid = ?1")
//public Float percentage(Integer studentid);
}
