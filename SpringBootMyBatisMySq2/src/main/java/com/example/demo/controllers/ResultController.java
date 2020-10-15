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

import com.example.demo.dto.DetailResultDto;
import com.example.demo.entities.StudyResult;
import com.example.demo.entities.Student;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repositories.ResultRepository;
import com.example.demo.repositories.StudentRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/result")
public class ResultController {

	@Autowired
	ResultRepository resultRepository;

	@PostMapping("/insert")
	public ResponseEntity<?> insertResult(@RequestBody StudyResult result) {
		resultRepository.insert(result);
		return ResponseEntity.ok(new MessageResponse("Result added successfully!"));
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<?> findByStudentId(@PathVariable int id) {
		List<DetailResultDto> results = resultRepository.findByStudentId(id);
		return ResponseEntity.ok(results);
	}

	/*
	 * @GetMapping() public ResponseEntity<?> findAll() { List<Student> students =
	 * resultRepository.findAll(); return ResponseEntity.ok(students); }
	 */
}
