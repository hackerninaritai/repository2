package com.example.demo.dto;

public class DetailResultDto {

	private String studentName;
	private String subjectName;
	private long mark1;
	private long mark2;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public long getMark1() {
		return mark1;
	}

	public void setMark1(long mark1) {
		this.mark1 = mark1;
	}

	public long getMark2() {
		return mark2;
	}

	public void setMark2(long mark2) {
		this.mark2 = mark2;
	}

	public DetailResultDto(String studentName, String subjectName, long mark1, long mark2) {
		super();
		this.studentName = studentName;
		this.subjectName = subjectName;
		this.mark1 = mark1;
		this.mark2 = mark2;
	}

	public DetailResultDto() {
		super();
	}

}
