package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entities.Subject;

@Mapper
public interface SubjectRepository {

	@Insert("INSERT INTO subject (ID, SUBJECT_NAME) VALUES (#{id}, #{subjectName})")
	public int insert(Subject subject);

	@Select("SELECT * FROM subject")
	public List<Subject> findAll();

	@Select("SELECT * FROM subject WHERE id= #{id} ")
	@Results({ @Result(property = "subjectName", column = "subject_name")})
	public Optional<Subject> findById(int id);

	@Delete("DELETE FROM subject WHERE id = #{id}")
	public int deleteById(int id);

	@Update(" UPDATE subject SET SUBJECT_NAME = #{subjectName} WHERE ID = #{id}")
	public int updateSubject(Subject subject);

}
