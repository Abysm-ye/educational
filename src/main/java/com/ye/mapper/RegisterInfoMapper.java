package com.ye.mapper;

import java.util.List;

import com.ye.pojo.Student;
import com.ye.pojo.Teacher;

public interface RegisterInfoMapper {
	
	public List<Student> selStuById(int uid);
	
	
	public List<Teacher> selTeaById(int id);
}
