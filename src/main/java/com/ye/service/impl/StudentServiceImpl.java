package com.ye.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ye.mapper.StudentMapper;
import com.ye.pojo.Course;
import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.ResultInfo;
import com.ye.pojo.Score;
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
	
	
	@Override
	public EasyUIDatagrid findStuCourse(int page,int rows,int uid) {
		//设置分页条件
		PageHelper.startPage(page, rows);
		//查询全部课表信息
		List<Course> list=studentMapper.selStuCourse(uid);
		//分页信息
		PageInfo<Course> pageInfo = new PageInfo<>(list);
		
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		datagrid.setRows(pageInfo.getList());
		datagrid.setTotal(pageInfo.getTotal());
		return datagrid;
	}


	@Override
	public EasyUIDatagrid findElective(int page, int rows) {
		//设置分页条件
		PageHelper.startPage(page, rows);
		
		List<Course> list=studentMapper.selElective();
		//分页信息
		PageInfo<Course> pageInfo = new PageInfo<>(list); 
		
		EasyUIDatagrid data = new EasyUIDatagrid();
		data.setRows(pageInfo.getList());
		data.setTotal(pageInfo.getTotal());
		return data;
	}


	@Override
	public ResultInfo addCourse(int courseId, int uid) {
		ResultInfo info = new ResultInfo();
		
		Object obj=studentMapper.selCourseById(courseId, uid);
		
		if(obj!=null) {
			//该课程以选过
			info.setFlag(false);
			info.setErrorMsg("该课程以选过，请重新选择一门课程！");
			return info;
		}
		
		int index=studentMapper.insElective(courseId, uid);
		if(index>0) {
			info.setFlag(true);
			info.setData("恭喜您，选课成功！");
			return info;
		}else {
			info.setFlag(false);
			info.setErrorMsg("选课失败，请联系维护人员！");
			return info;
		}
		
	}


	@Override
	public EasyUIDatagrid findScore(int page, int rows, int uid) {
		//分页条件
		PageHelper.startPage(page, rows);
		
		List<Score> list=studentMapper.selScore(uid);
		//分页信息
		PageInfo<Score> info = new PageInfo<Score>(list);
		
		//封装到EasyUIDatagrid中
		EasyUIDatagrid data = new EasyUIDatagrid();
		data.setRows(info.getList());
		data.setTotal(info.getTotal());
		return data;
	}
	
}
