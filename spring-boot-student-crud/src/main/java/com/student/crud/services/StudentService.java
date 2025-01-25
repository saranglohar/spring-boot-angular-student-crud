package com.student.crud.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.student.crud.entities.Student;

@Service
public class StudentService {

	List<Student> studentList = new ArrayList(List.of(new Student(1, "Sarnag", 50),new Student(2, "Sarnag2",650),new Student(3, "Sarnag3",60),new Student(4, "Sarnag4", 70)));
	
	
	public List<Student> getAllStudent() {
		return studentList;
	}
	
	public Student getStudentById(Integer studentId) {
		List<Student> students= studentList.stream().filter(stud -> stud.getId().equals(studentId)).toList();
		return students.size() > 0 ? students.get(0) : null;
	}
	
	public void createStudent(Student student) {
		studentList.add(student);
	}
	
	public void deleteStudent(Integer studentId) {
		studentList = new ArrayList<>(studentList.stream().filter(stud -> !stud.getId().equals(studentId)).toList());
	}
}
