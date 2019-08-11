package com.xv.SpringBootRestApi.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xv.SpringBootRestApi.Student;

@Mapper
public interface StudentMapper {

	public List<Student> getStudents();

	public Student getStudent(Integer id);

	public void save(Student student);

	public void insert(Student student);

	public void delete(Integer id);
}
