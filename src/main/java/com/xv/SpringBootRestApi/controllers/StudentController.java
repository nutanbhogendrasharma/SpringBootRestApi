package com.xv.SpringBootRestApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xv.SpringBootRestApi.Student;
import com.xv.SpringBootRestApi.mappers.StudentMapper;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	StudentMapper studentMapper;
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents(){
		return new ResponseEntity<List<Student>>(studentMapper.getStudents(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer id){
		return new ResponseEntity<Student>(studentMapper.getStudent(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Student> newStudent(@RequestBody Student student){
		studentMapper.insert(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@PostMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer id){
		student.setId(id);
        studentMapper.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id){
    	studentMapper.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
