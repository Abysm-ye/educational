package com.ye.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ye.pojo.Student;

public interface RegisterInfoMapper {
	
	public List<Student> selByPage(int uid,int pageStart,int pageSize);
	
	@Select("select count(*) from reg_info")
	public int selTotal();
}
