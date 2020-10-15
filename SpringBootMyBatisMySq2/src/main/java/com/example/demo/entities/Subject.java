package com.example.demo.entities;

public class Subject {
	private Long id;
	private String subjectName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Subject(Long id, String subjectName) {
		super();
		this.id = id;
		this.subjectName = subjectName;
	}

	public Subject(String subjectName) {
		super();
		this.subjectName = subjectName;
	}

	public Subject() {
		super();
	}

}
