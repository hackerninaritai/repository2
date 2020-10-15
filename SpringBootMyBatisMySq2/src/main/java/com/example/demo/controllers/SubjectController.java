package com.example.demo.controllers;

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

import com.example.demo.entities.Subject;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repositories.SubjectRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/subject")
public class SubjectController {
	@Autowired
	SubjectRepository subjectRepository;

	@PostMapping("/insert")
	public ResponseEntity<?> insertSubject(@RequestBody Subject subject) {
		subjectRepository.insert(subject);
		return ResponseEntity.ok(new MessageResponse("Student added successfully!"));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		Optional<Subject> opt = subjectRepository.findById(id);
		if (opt.isPresent()) {
			return ResponseEntity.ok(opt.get());
		}
		return ResponseEntity.ok(new MessageResponse("Subject not found!"));
	}
}
