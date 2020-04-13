package com.ye.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ye.mapper.TeacherMapper;
import com.ye.pojo.Course;
import com.ye.pojo.EasyUIDatagrid;
import com.ye.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Resource
	private TeacherMapper teacherMapper;
	
	@Override
	public EasyUIDatagrid findTeaCourse(int page,int rows,int uid) {
		
		//设置分页条件
		PageHelper.startPage(page, rows);
		
		//查询全部
		List<Course> list=teacherMapper.selTeaCourse(uid);
		
		//分页信息
		PageInfo<Course> pageInfo = new PageInfo<>(list);
		//将分页信息放到EasyUIDataGrid中
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		datagrid.setRows(pageInfo.getList());
		datagrid.setTotal(pageInfo.getTotal());
		return datagrid;
	}

}
