package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Integer>{
	@Query("Select ((m.Subject1 + m.Subject2 + m.Subject3 + m.Subject4)/m.totalmarks)*100 from Student as s join Marks as m on m.student = s.studentid where s.studentid = ?1")
	public Float percentage(Integer studentid);
}
