package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repositories.StudentRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@PostMapping("/insert")
	public ResponseEntity<?> insertStudent(@RequestBody Student student) {
		studentRepository.insert(student);
		return ResponseEntity.ok(new MessageResponse("Student added successfully!"));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		Optional<Student> opt = studentRepository.findById(id);
		if (opt.isPresent()) {
			return ResponseEntity.ok(opt.get());
		}
		return ResponseEntity.ok(new MessageResponse("Student not found!"));
	}
	
	@GetMapping()
	public ResponseEntity<?> findAll() {
		List<Student> students = studentRepository.findAll();
		return ResponseEntity.ok(students);
	}
}
