package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.example.dao.Marks;
import com.example.dao.MarksRepository;
import com.example.dao.Student;
import com.example.dao.StudentRepository;

@EntityScan(basePackageClasses= {Student.class,Marks.class})
@SpringBootApplication(scanBasePackages = {"com.example.dao","com.example.security","com.example.security.service","com.example.customhttpeaders","com.example.dao","com.example.controllers","com.example.service"})
@EnableJpaRepositories(basePackageClasses = {StudentRepository.class,MarksRepository.class})
public class VannaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VannaApplication.class, args);
	}

}
