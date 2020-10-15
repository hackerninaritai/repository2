package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entities.Student;

@Mapper
public interface StudentRepository {

	@Insert("INSERT INTO student (ID, NAME, BRANCH, PERCENTAGE, PHONE, EMAIL ) VALUES (#{id}, #{name}, #{branch}, #{percentage}, #{phone}, #{email})")
	public int insert(Student student);

	@Select("SELECT * FROM student")
	public List<Student> findAll();

	@Select("SELECT * FROM student WHERE id= #{id} ")
	public Optional<Student> findById(int id);

	@Delete("DELETE FROM student WHERE id = #{id}")
	public int deleteById(int id);

	@Update(" UPDATE STUDENT SET EMAIL = #{email}, NAME = #{name}, BRANCH = #{branch}, PERCENTAGE = #{percentage}, PHONE = #{phone} WHERE ID = #{id}")
	public int updateStudent(Student student);
}
