package com.spring.data.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.data.jpa.model.Student;
import com.spring.data.jpa.repo.StudentRepo;

@SpringBootApplication
@ComponentScan
public class Application {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		StudentRepo repo = context.getBean(StudentRepo.class);
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);
		
		s1.setRollNo(1);
		s1.setName("ben10");
		s1.setMarks(100);
		
		s2.setRollNo(2);
		s2.setName("ga");
		s2.setMarks(11);
		
		s3.setRollNo(3);
		s3.setName("ga");
		s3.setMarks(19);
		
		repo.save(s1);
		repo.save(s2);
		System.out.println(repo.findByName("ga"));
	}

}
