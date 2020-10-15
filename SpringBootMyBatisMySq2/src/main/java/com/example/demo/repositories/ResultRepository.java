package com.example.demo.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.DetailResultDto;
import com.example.demo.entities.StudyResult;

@Mapper
public interface ResultRepository {

	@Insert("INSERT INTO result (student_id, subject_id, mark1, mark2) VALUES (#{studentId}, #{subjectId}, #{mark1}, #{mark2})")
	public int insert(StudyResult result);

	@Select("SELECT st.name, s.subject_name, r.mark1, r.mark2 FROM student st JOIN result r ON st.id = r.student_id JOIN subject s ON s.id = r.subject_id WHERE student_id=#{id}")
	@Results({ @Result(property = "subjectName", column = "subject_name"),
			@Result(property = "studentName", column = "name") })
	public List<DetailResultDto> findByStudentId(int id);

}
