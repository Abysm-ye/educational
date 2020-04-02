package com.ye.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ye.mapper.RegisterInfoMapper;
import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.Student;
import com.ye.service.RegisterInfoService;

@Service
public class RegisterInfoServiceImpl implements RegisterInfoService{
	@Resource
	private RegisterInfoMapper registerInfoMapper;
	
	@Override
	public EasyUIDatagrid selStuRegInfoById(int page,int rows,int uid) {
		//设置分页条件
		PageHelper.startPage(page, rows);
		//查询全部
		List<Student> list=registerInfoMapper.selStuById(uid);
		//分页信息
		PageInfo<Student> pageInfo = new PageInfo<>(list);
		//将分页信息放到EasyUIDataGrid中
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		datagrid.setRows(pageInfo.getList());
		datagrid.setTotal(pageInfo.getTotal());
		return datagrid;
	}

	@Override
	public EasyUIDatagrid selTeaRegInfoById(int id) {
		
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		datagrid.setRows(registerInfoMapper.selTeaById(id));
		datagrid.setTotal(1);
		return datagrid;
	}

}
