package com.uap.it1311l.studentsubjectratingapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uap.it1311l.studentsubjectratingapi.models.Information;
import com.uap.it1311l.studentsubjectratingapi.repository.MyBatisRepositoryStudent;

@RestController
public class StudentController {
	@Autowired
	MyBatisRepositoryStudent studentRepo;
	
	@PostMapping ("/event/student/information")
	public Information processStudentInformation(@RequestBody Information student) {
	    studentRepo.insert(student);
	    
	    if (student.getAverageGrade() >= 85) {
	        student.setComment("Within the Maintaining average");
	    } else {
	        student.setComment("For Improvement");
	    }

	    return student; 
	}

	@SpringBootApplication
	public class StudentGradeApiApplication {
	    public static void main(String[] args) {
	        SpringApplication.run(StudentGradeApiApplication.class, args);
	    }
	}
}
