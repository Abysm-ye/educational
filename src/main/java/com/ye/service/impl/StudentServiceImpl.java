package com.ye.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ye.mapper.StudentMapper;
import com.ye.pojo.User;
import com.ye.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Resource
	private StudentMapper studentMapper;
	@Override
	public User findStuInfo(int id) {
		
		return studentMapper.selStuInfoById(id);
	}

}
