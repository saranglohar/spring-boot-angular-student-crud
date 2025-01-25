package com.student.crud.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.crud.entities.Student;
import com.student.crud.services.StudentService;

@RestController
@CrossOrigin("http://localhost:4200")
public class StudentController {
	
	 Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentService studentService;

	
	@GetMapping("/students")
	public List<Student> getAllStudent() {
		logger.info("Request to fetch all students");
		return this.studentService.getAllStudent();
	}
	
	@GetMapping("/students/{id}")
	public Student getAllStudent(@PathVariable Integer id) {
		logger.info("Request to get student by id= " + id);
		return this.studentService.getStudentById(id);
	}

	@PostMapping("/students")
	public void createStudent(@RequestBody Student student) {
		logger.info("Request student cration : " + student);
		this.studentService.createStudent(student);
	}
	
	@DeleteMapping("/students/{id}")
	public void delete(@PathVariable Integer id) {
		logger.info("Request to delete student by id= " + id);
		this.studentService.deleteStudent(id);
	}

}


///Student

// Fetch all students  GET /students   --- get
// GET one student   GET /students/12
// Create student POST /students
// UPdate student PUT /students
// Delete student DELETE /students/1221212
  